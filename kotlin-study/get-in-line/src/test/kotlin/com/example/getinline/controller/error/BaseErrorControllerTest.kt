package com.example.getinline.controller.error

import io.kotest.core.spec.style.FunSpec
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(BaseErrorController::class)
class BaseErrorControllerTest(@Autowired val mockMvc: MockMvc) : FunSpec() {

    @Test
    @DisplayName("[view][GET] 에러 페이지 - 페이지 없음")
    fun test() {
        mockMvc.perform(MockMvcRequestBuilders.get("/wroong-url"))
            .andExpect(MockMvcResultMatchers.status().isNotFound)
            .andDo(MockMvcResultHandlers.print())
    }

}
