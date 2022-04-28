import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.7"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

group = "com.bootcamp"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
object Version {
    const val testcontainersVersion = "1.15.3"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.testcontainers:mariadb")
    testImplementation("org.testcontainers:junit-jupiter")
    testRuntimeOnly("org.mariadb.jdbc:mariadb-java-client")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    dependencies {
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:${Version.testcontainersVersion}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
