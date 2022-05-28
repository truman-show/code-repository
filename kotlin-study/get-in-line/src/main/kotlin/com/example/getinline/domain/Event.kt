package com.example.getinline.domain

import com.example.getinline.constant.EventStatus
import java.time.LocalDateTime

data class Event(
    val id: Long, val placeId: Long, val eventName: String,
    val eventStatus: EventStatus, val eventStartDatetime: LocalDateTime,
    val eventEndDatetime: LocalDateTime, val currentNumberOfPeople: Int, val capacity: Int,
    val memo: String, val createdAt: LocalDateTime, val modified: LocalDateTime
)
