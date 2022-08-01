import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.6"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.asciidoctor.jvm.convert") version "3.3.2"
    kotlin("jvm") version "1.5.31"
    kotlin("plugin.spring") version "1.5.31"
    id("com.epages.restdocs-api-spec") version "0.16.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}


val asciidoctorExtensions: Configuration by configurations.creating

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")

    testImplementation("com.epages:restdocs-api-spec-mockmvc:0.16.2")

    asciidoctorExtensions("org.springframework.restdocs:spring-restdocs-asciidoctor")

}

configure<com.epages.restdocs.apispec.gradle.OpenApi3Extension> {
    setServer("https://localhost:8080")
    title = "My API"
    description = "My API description"
    version = "0.1.0"
    format = "yaml"
}

tasks{

    val snippetsDir = file("$buildDir/generated-snippets")

    test {
        outputs.dir(snippetsDir)
        useJUnitPlatform()
    }

    asciidoctor {
        inputs.dir(snippetsDir)
        dependsOn(test)
    }

    bootJar {
        dependsOn(asciidoctor, "openapi3")

        from("$buildDir/api-spec"){
            into("/BOOT-INF/classes/static/docs")
        }
    }

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
