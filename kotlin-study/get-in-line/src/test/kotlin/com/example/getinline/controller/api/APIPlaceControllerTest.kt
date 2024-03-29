package com.example.getinline.controller.api

import com.example.getinline.constant.ErrorCode
import com.example.getinline.constant.PlaceType
import com.example.getinline.controller.common.BasicController
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(APIPlaceController::class)
class APIPlaceControllerTest : BasicController() {

    init {
        test("[API][GET] 장소 리스트 조회 - 장소 리스트 데이터를 담은 표준 API 출력") {
            // Given

            // When & Then
            mockMvc.perform(MockMvcRequestBuilders.get("/api/places"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isArray)
                .andExpect(
                    MockMvcResultMatchers.jsonPath("$.data[0].placeType")
                        .value(PlaceType.COMMON.name)
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].placeName").value("랄라배드민턴장"))
                .andExpect(
                    MockMvcResultMatchers.jsonPath("$.data[0].address").value("서울시 강남구 강남대로 1234")
                )
                .andExpect(
                    MockMvcResultMatchers.jsonPath("$.data[0].phoneNumber").value("010-1234-5678")
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].capacity").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data[0].memo").value("신장개업"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorCode.OK.code))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorCode.OK.message))
        }

        test("[API][GET] 단일 장소 조회") {
            // Given
            val placeId = 1

            // When & Then
            mockMvc.perform(MockMvcRequestBuilders.get("/api/places/${placeId}"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isMap)
                .andExpect(
                    MockMvcResultMatchers.jsonPath("$.data.placeType").value(PlaceType.COMMON.name)
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.placeName").value("랄라배드민턴장"))
                .andExpect(
                    MockMvcResultMatchers.jsonPath("$.data.address").value("서울시 강남구 강남대로 1234")
                )
                .andExpect(
                    MockMvcResultMatchers.jsonPath("$.data.phoneNumber").value("010-1234-5678")
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.capacity").value(30))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.memo").value("신장개업"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorCode.OK.code))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorCode.OK.message))
        }

        test("[API][GET] 단일 장소 조회 - 장소가 없는 경우") {
            // Given
            val placeId = 2

            // When & Then
            mockMvc.perform(MockMvcRequestBuilders.get("/api/places/${placeId}"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").isEmpty)
                .andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errorCode").value(ErrorCode.OK.code))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(ErrorCode.OK.message))
                .andDo(MockMvcResultHandlers.print())
        }
    }

}
