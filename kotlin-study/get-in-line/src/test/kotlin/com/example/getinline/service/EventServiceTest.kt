package com.example.getinline.service

import com.example.getinline.controller.api.dto.EventDto
import com.example.getinline.repository.EventRepository
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = [EventService::class, EventRepository::class])
class EventServiceTest(
    private val eventService: EventService,
    @MockkBean(relaxed = true) private val eventRepository: EventRepository
) : DescribeSpec() {

    init {
        fun subject(): List<EventDto> {
            return eventService.findEvents(
                null, null, null, null, null
            )
        }

        describe("findEvents 메소드는") {
            context("이벤트를 검색하면") {
                val subject = subject()
                it("이벤트 결과를 출력하여 보여준다.") {
                    subject shouldBe listOf()
                }
            }
        }
    }

}
