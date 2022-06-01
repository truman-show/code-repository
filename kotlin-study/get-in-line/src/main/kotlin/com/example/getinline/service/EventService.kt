package com.example.getinline.service

import com.example.getinline.constant.EventStatus
import com.example.getinline.controller.api.dto.EventDto
import com.example.getinline.repository.EventRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EventService(private val eventRepository: EventRepository) {

    fun findEvents(
        placeId: Long?,
        eventName: String?,
        eventStatus: EventStatus?,
        eventStartDatetime: LocalDateTime?,
        eventEndDatetime: LocalDateTime?
    ): List<EventDto> {
        return eventRepository.findEvents(
            placeId,
            eventName,
            eventStatus,
            eventStartDatetime,
            eventEndDatetime
        )
    }


    fun getEvent(eventId: Long?): EventDto? {
        return eventRepository.findEvent(eventId)
    }

    fun createEvent(eventDTO: EventDto): Boolean {
        return eventRepository.insertEvent(eventDTO)
    }

    fun modifyEvent(eventId: Long?, dto: EventDto): Boolean {
        return eventRepository.updateEvent(eventId, dto)
    }

    fun removeEvent(eventId: Long): Boolean {
        return eventRepository.deleteEvent(eventId)
    }
}
