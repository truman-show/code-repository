package com.bootcamp

import com.bootcamp.properties.MyProperties
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.core.env.Environment
import javax.annotation.PostConstruct

@SpringBootApplication
@ConfigurationPropertiesScan
class KotlinSpringBootcampApplication(
    @Value("\${my.height}") var height: String,
    var enviroment: Environment,
    var applicationContext: ApplicationContext,
    val myProperties: MyProperties
) {

    // companion(동반자) 객체
    // KotlinSpringBootcampApplication.Companion.main 과 KotlinSpringBootcampApplication.main 같다
    // https://www.bsidesoft.com/8187
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<KotlinSpringBootcampApplication>(*args)
        }
    }

    @PostConstruct
    // 초기화 수행을 위해 종속성 주입이 완료 된 후 실행 되는 메서드에 사용하는 애노테이션
    // height 값이 주입된 후 실행되는것을 확인 할 수 있다.
    fun init() {

        println("=========")
        println("height!! : $height")
        println("Enviroment!! : ${enviroment.getProperty("my.height")}")
        println("ApplicationContext!! : ${applicationContext.environment.getProperty("my.height")}")
        println("myProperties!! : ${myProperties.height}")
        println("=========")
    }

}
