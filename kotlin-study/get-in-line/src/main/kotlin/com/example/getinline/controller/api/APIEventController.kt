package com.example.getinline.controller.api

import com.example.getinline.constant.EventStatus
import com.example.getinline.controller.api.dto.EventDto
import com.example.getinline.exception.GeneralException
import com.example.getinline.response.APIDataResponse
import com.example.getinline.response.APIErrorResponse
import com.example.getinline.response.APIErrorResponse.Companion.of
import com.example.getinline.service.EventService
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
import kotlin.streams.toList

@RestController
@RequestMapping("/api")
class APIEventController(private val eventService: EventService) {

    @GetMapping("/events")
    fun getEvents(
        placeId: Long,
        eventName: String,
        eventStatus: EventStatus,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) eventStartDatetime: LocalDateTime,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) eventEndDatetime: LocalDateTime
    ): APIDataResponse<List<EventDto.EventResponse>> {

        val eventResponses: List<EventDto.EventResponse> = eventService.findEvents(
            placeId,
            eventName,
            eventStatus,
            eventStartDatetime,
            eventEndDatetime
        ).stream().map(EventDto.EventResponse::from).toList()

        return APIDataResponse.of(eventResponses)

    }

    @PostMapping("/events")
    fun createEvent(): Boolean? {
        return true
    }

    @GetMapping("/events/{eventId}")
    fun getEvent(@PathVariable eventId: Int): String? {
        return "event $eventId"
    }

    @PutMapping("/events/{eventId}")
    fun modifyEvent(@PathVariable eventId: Int?): Boolean? {
        return true
    }

    @DeleteMapping("/events/{eventId}")
    fun removeEvent(@PathVariable eventId: Int?): Boolean? {
        return true
    }

    // APIEventController 의 핸들러 메소드들 중에서 GeneralException 예외가 발생했을 때 예외를 잡아 후처리를 한다
    @ExceptionHandler
    fun general(e: GeneralException): ResponseEntity<APIErrorResponse> {
        val errorCode = e.errorCode
        val status =
            if (errorCode.isClientSideError()) HttpStatus.BAD_REQUEST else HttpStatus.INTERNAL_SERVER_ERROR

        return ResponseEntity
            .status(status)
            .body(
                of(false, errorCode, errorCode.message(e))
            )
    }

}
