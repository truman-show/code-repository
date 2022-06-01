package com.example.getinline.controller

import com.example.getinline.constant.PlaceType
import com.example.getinline.controller.common.BasicController
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(AdminController::class)
class AdminControllerTest : BasicController() {

    init {

        test("[view][GET] 어드민 페이지 - 장소 리스트 뷰") {
            // Given

            // When & Then
            mockMvc.perform(
                get("/admin/places")
                    .queryParam("placeType", PlaceType.SPORTS.name)
                    .queryParam("placeName", "랄라배드민턴장")
                    .queryParam("address", "서울시 강남구 강남대로 1234")
            )
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(view().name("admin/places"))
        }

    }

}
