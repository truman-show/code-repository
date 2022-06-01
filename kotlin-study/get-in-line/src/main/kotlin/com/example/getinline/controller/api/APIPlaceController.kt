package com.example.getinline.controller.api

import com.example.getinline.constant.PlaceType
import com.example.getinline.controller.api.dto.PlaceDto
import com.example.getinline.response.APIDataResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class APIPlaceController {

    @GetMapping("/places")
    fun getPlaces(): APIDataResponse<List<PlaceDto.PlaceResponseDto>> {
        return APIDataResponse.of(
            listOf(
                PlaceDto.PlaceResponseDto.of(
                    1L,
                    PlaceType.COMMON,
                    "랄라배드민턴장",
                    "서울시 강남구 강남대로 1234",
                    "010-1234-5678",
                    30,
                    "신장개업"
                )
            )
        )
    }

    @PostMapping("/places")
    fun createPlace(): Boolean? {
        return true
    }

    @GetMapping("/places/{placeId}")
    fun getPlace(@PathVariable placeId: Int): APIDataResponse<PlaceDto.PlaceResponseDto> {

        if (placeId == 2) return APIDataResponse.of(null)

        return APIDataResponse.of(
            PlaceDto.PlaceResponseDto.of(
                1L,
                PlaceType.COMMON,
                "랄라배드민턴장",
                "서울시 강남구 강남대로 1234",
                "010-1234-5678",
                30,
                "신장개업"
            )
        )
    }

    @PutMapping("/places/{placeId}")
    fun modifyPlace(@PathVariable placeId: Int?): Boolean? {
        return true
    }

    @DeleteMapping("/places/{placeId}")
    fun removePlace(@PathVariable placeId: Int?): Boolean? {
        return true
    }

}
