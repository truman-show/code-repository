package com.example.getinline.controller.api.dto

import com.example.getinline.constant.EventStatus
import java.time.LocalDateTime

class EventDto(
    val id: Long?,
    val place: PlaceDto?,
    val eventName: String?,
    val eventStatus: EventStatus?,
    val eventStartDatetime: LocalDateTime?,
    val eventEndDatetime: LocalDateTime?,
    val currentNumberOfPeople: Int?,
    val capacity: Int?,
    val memo: String?
) {

    data class EventResponse(
        val id: Long?,
        val place: Int?,
        val eventName: String?,
        val eventStatus: EventStatus?,
        val eventStartDatetime: LocalDateTime?,
        val eventEndDatetime: LocalDateTime?,
        val currentNumberOfPeople: Int?,
        val capacity: Int?,
        val memo: String?,
    ) {
        companion object {

            fun of(
                id: Long?,
                place: PlaceDto?,
                eventName: String?,
                eventStatus: EventStatus?,
                eventStartDatetime: LocalDateTime?,
                eventEndDatetime: LocalDateTime?,
                currentNumberOfPeople: Int?,
                capacity: Int?,
                memo: String?
            ): EventResponse {

                return EventResponse(
                    id,
                    place?.placeId,
                    eventName,
                    eventStatus,
                    eventStartDatetime,
                    eventEndDatetime,
                    currentNumberOfPeople,
                    capacity,
                    memo
                )
            }

            fun from(eventDto: EventDto?): EventResponse? {
                if (eventDto != null) {
                    return of(
                        eventDto.id,
                        eventDto.place,
                        eventDto.eventName,
                        eventDto.eventStatus,
                        eventDto.eventStartDatetime,
                        eventDto.eventEndDatetime,
                        eventDto.currentNumberOfPeople,
                        eventDto.capacity,
                        eventDto.memo
                    )
                }
                return null
            }

            fun empty(placeDto: PlaceDto?): EventResponse {
                return of(null, placeDto, null, null, null, null, null, null, null)
            }

        }
    }

}
