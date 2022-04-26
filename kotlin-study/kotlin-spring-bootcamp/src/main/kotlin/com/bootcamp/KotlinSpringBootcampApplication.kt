package com.bootcamp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringBootcampApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringBootcampApplication>(*args)
}
