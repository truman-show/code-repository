package com.example.getinline.service

import com.example.getinline.constant.EventStatus
import com.example.getinline.controller.api.dto.EventDto
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class EventService {

    fun findEvents(
        placeId: Long?,
        eventName: String?,
        eventStatus: EventStatus?,
        eventStartDatetime: LocalDateTime?,
        eventEndDatetime: LocalDateTime?
    ): List<EventDto> {
        return listOf()
    }

}
