package com.example.getinline.controller

import com.example.getinline.controller.common.BasicController
import org.hamcrest.CoreMatchers
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@WebMvcTest(BaseController::class)
class BaseControllerTest : BasicController() {
    init {
        test("[view][GET] 기본 페이지 요청") {
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
}
