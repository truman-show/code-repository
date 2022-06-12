package com.example.getinline.controller.api

import com.example.getinline.constant.EventStatus
import com.example.getinline.controller.api.dto.EventDto
import com.example.getinline.response.APIDataResponse
import com.example.getinline.service.EventService
import org.springframework.format.annotation.DateTimeFormat
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
    ): APIDataResponse<List<EventDto.EventResponse?>> {

        val eventResponses: List<EventDto.EventResponse?> = eventService.findEvents(
            placeId,
            eventName,
            eventStatus,
            eventStartDatetime,
            eventEndDatetime
        ).stream().map(EventDto.EventResponse::from)
            .toList()

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

}
