package com.example.getinline.controller.api

import com.example.getinline.constant.ErrorCode
import com.example.getinline.constant.EventStatus
import com.example.getinline.controller.api.dto.EventDto
import com.example.getinline.controller.api.dto.PlaceDto
import com.example.getinline.controller.common.BasicController
import com.example.getinline.service.EventService
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@WebMvcTest(APIEventController::class)
class APIEventControllerTest : BasicController() {

    @MockkBean(relaxed = true)
    lateinit var eventService: EventService


    init {
        test("[API][GET] 이벤트 리스트 조회 + 검색 파라미터") {

            every {
                eventService.findEvents(
                    any(),
                    any(),
                    any(),
                    any(),
                    any()
                )
            } returns listOf(
                EventDto(
                    1L, PlaceDto(1), "오후 운동",
                    eventStatus = EventStatus.OPENED,
                    eventStartDatetime = LocalDateTime.of(2021, 1, 1, 13, 0, 0),
                    eventEndDatetime = LocalDateTime.of(2021, 1, 1, 16, 0, 0),
                    currentNumberOfPeople = 0,
                    capacity = 24,
                    memo = "마스크 꼭 착용하세요"
                )
            )

            // When & Then
            mockMvc.perform(
                get("/api/events")
                    .queryParam("placeId", "1")
                    .queryParam("eventName", "운동")
                    .queryParam("eventStatus", EventStatus.OPENED.name)
                    .queryParam("eventStartDatetime", "2021-01-01T00:00:00")
                    .queryParam("eventEndDatetime", "2021-01-02T00:00:00")
            )
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data").isArray)
                .andExpect(jsonPath("$.data[0].place").value(1L))
                .andExpect(jsonPath("$.data[0].eventName").value("오후 운동"))
                .andExpect(jsonPath("$.data[0].eventStatus").value(EventStatus.OPENED.name))
                .andExpect(
                    jsonPath("$.data[0].eventStartDatetime").value(
                        LocalDateTime
                            .of(2021, 1, 1, 13, 0, 0)
                            .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    )
                )
                .andExpect(
                    jsonPath("$.data[0].eventEndDatetime").value(
                        LocalDateTime
                            .of(2021, 1, 1, 16, 0, 0)
                            .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                    )
                )
                .andExpect(jsonPath("$.data[0].currentNumberOfPeople").value(0))
                .andExpect(jsonPath("$.data[0].capacity").value(24))
                .andExpect(jsonPath("$.data[0].memo").value("마스크 꼭 착용하세요"))
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.errorCode").value(ErrorCode.OK.code))
                .andExpect(jsonPath("$.message").value(ErrorCode.OK.message))
        }
    }
}
