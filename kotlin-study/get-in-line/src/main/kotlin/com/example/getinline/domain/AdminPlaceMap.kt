package com.example.getinline.domain

import java.time.LocalDateTime

data class AdminPlaceMap(
    val id: Long, val adminId: Long, val placeId: Long,
    val createdAt: LocalDateTime, val modified: LocalDateTime
)
