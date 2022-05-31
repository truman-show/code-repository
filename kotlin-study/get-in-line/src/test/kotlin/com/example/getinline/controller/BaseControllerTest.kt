package com.example.getinline.controller

import io.kotest.core.spec.style.FunSpec
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(BaseController::class)
class BaseControllerTest(
    @Autowired val mockMvc: MockMvc
) : FunSpec() {

    @Test
    @DisplayName("[view][GET] 기본 페이지 요청")
    fun test() {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.TEXT_HTML)
            )
            .andExpect(
                MockMvcResultMatchers.content()
                    .string(CoreMatchers.containsString("This is default Page."))
            )
            .andExpect(MockMvcResultMatchers.view().name("index"))
            .andDo(MockMvcResultHandlers.print())
    }
}
