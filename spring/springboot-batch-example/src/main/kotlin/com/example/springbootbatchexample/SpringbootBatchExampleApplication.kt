package com.example.springbootbatchexample

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableBatchProcessing
@SpringBootApplication
class SpringbootBatchExampleApplication

fun main(args: Array<String>) {
    runApplication<SpringbootBatchExampleApplication>(*args)
}
