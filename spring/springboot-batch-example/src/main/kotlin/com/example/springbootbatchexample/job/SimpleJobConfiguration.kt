package com.example.springbootbatchexample.job

import mu.KotlinLogging
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepScope
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

private val log = KotlinLogging.logger {}

@Configuration
class SimpleJobConfiguration(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val simpleTasklet: SimpleTasklet,
) {

    @Bean
    fun simpleJob(): Job {
        return jobBuilderFactory.get("simpleJob")
            .start(simpleStep1())
            .next(simpleStep2())
            .build()
    }

    @Bean
    fun simpleStep1(): Step {
        return stepBuilderFactory.get("simpleStep1")
            .tasklet { _, _ ->
                log.info { ">> This is simpleStep1 <<" }
                RepeatStatus.FINISHED
            }
            .build()
    }

    @Bean
    fun simpleStep2(): Step {
        return stepBuilderFactory.get("simpleStep2")
            .tasklet(simpleTasklet)
            .build()
    }

}

@Component
@StepScope
class SimpleTasklet : Tasklet {
    override fun execute(
        contribution: StepContribution,
        chunkContext: ChunkContext
    ): RepeatStatus? {
        log.info { "This is simpleStep2" }
        return RepeatStatus.FINISHED
    }
}
