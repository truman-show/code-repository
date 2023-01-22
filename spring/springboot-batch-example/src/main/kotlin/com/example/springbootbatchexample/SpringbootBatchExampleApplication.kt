package com.example.springbootbatchexample

import mu.KotlinLogging
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

private val log = KotlinLogging.logger { }

@EnableBatchProcessing
@SpringBootApplication
class SpringbootBatchExampleApplication/*(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
) {

    @Bean
    fun step(): Step {
        return this.stepBuilderFactory.get("step1")
            .tasklet { _, _ ->
                log.info { "Hello, World!" }
                println("Hello, World!")
                RepeatStatus.FINISHED
            }.build()
    }

    @Bean
    fun job(): Job {
        return this.jobBuilderFactory.get("job")
            .start(step())
            .build()
    }
}
*/

fun main(args: Array<String>) {
    runApplication<SpringbootBatchExampleApplication>(*args)
}
