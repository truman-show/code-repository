package com.example.getinline.controller.api.dto

import com.example.getinline.constant.EventStatus
import java.time.LocalDateTime

class EventDto(
    val id: Long,
    val placeDto: PlaceDto,
    val eventName: String,
    val eventStatus: EventStatus,
    val eventStartDatetime: LocalDateTime,
    val eventEndDatetime: LocalDateTime,
    val currentNumberOfPeople: Int,
    val capacity: Int,
    val memo: String,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime
) {

    companion object {
        fun of(
            id: Long,
            placeDto: PlaceDto,
            eventName: String,
            eventStatus: EventStatus,
            eventStartDatetime: LocalDateTime,
            eventEndDatetime: LocalDateTime,
            currentNumberOfPeople: Int,
            capacity: Int,
            memo: String,
            createdAt: LocalDateTime,
            modifiedAt: LocalDateTime
        ): EventDto {
            return EventDto(
                id,
                placeDto,
                eventName,
                eventStatus,
                eventStartDatetime,
                eventEndDatetime,
                currentNumberOfPeople,
                capacity,
                memo,
                createdAt,
                modifiedAt
            )
        }
    }
}
