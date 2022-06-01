package com.example.getinline.repository

import com.example.getinline.constant.EventStatus
import com.example.getinline.controller.api.dto.EventDto
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface EventRepository {

    fun findEvents(
        placeId: Long?,
        eventName: String?,
        eventStatus: EventStatus?,
        eventStartDatetime: LocalDateTime?,
        eventEndDatetime: LocalDateTime?
    ): List<EventDto> {
        return listOf()
    }

    fun findEvent(eventId: Long?): EventDto? = null

    fun insertEvent(eventDTO: EventDto?): Boolean = false

    fun updateEvent(eventId: Long?, dto: EventDto?): Boolean = false

    fun deleteEvent(eventId: Long?): Boolean = false

}
