package com.example.getinline.controller.api.dto

import com.example.getinline.constant.PlaceType

class PlaceDto(val placeId: Int) {

    data class PlaceResponseDto(
        val id: Long,
        val placeType: PlaceType,
        val placeName: String,
        val address: String,
        val phoneNumber: String,
        val capacity: Int,
        val memo: String,
    ) {

        companion object {
            fun of(
                id: Long, placeType: PlaceType, placeName: String, address: String,
                phoneNumber: String, capacity: Int, memo: String,
            ): PlaceResponseDto {
                return PlaceResponseDto(
                    id, placeType, placeName, address, phoneNumber, capacity, memo
                )
            }
        }
    }

}
