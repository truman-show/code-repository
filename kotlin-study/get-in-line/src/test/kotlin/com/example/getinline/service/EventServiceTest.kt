package com.example.getinline.service

import com.example.getinline.controller.api.dto.EventDto
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [(EventService::class)])
class EventServiceTest(eventService: EventService) : DescribeSpec({

    fun subject(): List<EventDto> {
        return eventService.findEvents(
            null, null, null, null, null
        )
    }

    describe("findEvents 메소드는") {
        context("조건이 주어지면") {
            val subject = subject()
            it("이벤트 목록을 리턴한다") {
                subject shouldBe listOf(1, 2, 3)
            }
        }
    }

})
