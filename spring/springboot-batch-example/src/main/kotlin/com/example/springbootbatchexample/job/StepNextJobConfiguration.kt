package com.example.springbootbatchexample.job

import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

private val log = KotlinLogging.logger { }

@Configuration
class StepNextJobConfiguration(
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory
) {
    @Bean
    fun stepNextJob(): Job {
        return jobBuilderFactory["stepNextJob"]
            .start(step1())
            .next(step2())
            .next(step3())
            .build()
    }

    @Bean
    fun step1(): Step {
        return stepBuilderFactory["step1"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                log.info(">>>>> This is Step1")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun step2(): Step {
        return stepBuilderFactory["step2"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                log.info(">>>>> This is Step2")
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun step3(): Step {
        return stepBuilderFactory["step3"]
            .tasklet { contribution: StepContribution?, chunkContext: ChunkContext? ->
                log.info(">>>>> This is Step3")
                RepeatStatus.FINISHED
            }
            .build()
    }
}
