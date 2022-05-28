package com.example.getinline.domain

import com.example.getinline.constant.PlaceType
import java.time.LocalDateTime

data class Place(
    val id: Long, val placeType: PlaceType, val placeName: String,
    val address: String, val phoneNumber: String, val capacity: Int,
    val memo: String, val createdAt: LocalDateTime, val modified: LocalDateTime
)
