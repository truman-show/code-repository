package com.example.getinline.controller.error

import com.example.getinline.controller.common.BasicController
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(BaseErrorController::class)
class BaseErrorControllerTest : BasicController() {
    init {
        test("[view][GET] 에러 페이지 - 페이지 없음") {
            mockMvc.perform(MockMvcRequestBuilders.get("/wroong-url"))
                .andExpect(MockMvcResultMatchers.status().isNotFound)
                .andDo(MockMvcResultHandlers.print())
        }
    }
}
