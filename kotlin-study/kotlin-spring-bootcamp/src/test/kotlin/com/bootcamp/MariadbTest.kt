package com.bootcamp

import org.junit.jupiter.api.Test
import org.testcontainers.containers.MariaDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
class MariadbTest {

    companion object {
        /*
        - 기본설정만으로도 컨테이너를 띄울수있다. MariaDBContainer 에는 기본접속정보가 입력되어있다. test/test
        @Container
        val container = MariaDBContainer("mariadb:10.7.3")// dockerhub에 있는 이미지 정보를 입력해야한다.
        */

        // 아래와 같이 접속정보를 입력하고 init 쿼리를 수행시키거나 설정정보 파일을 주어 컨테이너를 띄울 수 있다.
        @Container
        val container: MariaDBContainer<*> = MariaDBContainer("mariadb:10.7.3")
//            .withConfigurationOverride("conf.d.105")// classpath:conf.d.105 폴더의 파일을 컨테이너의 /etc/mysql/conf.d 폴더에 파일 복사
            .withUsername("test")
            .withPassword("test")
            .withDatabaseName("mariaDB")
        //.withInitScript("init.sql") 클래스패스(resource)에 위치하는 sql파일을 구동시 실행

    }

    @Test
    fun connect() {
        println("jdbcUrl:${container.jdbcUrl}")
    }

}




