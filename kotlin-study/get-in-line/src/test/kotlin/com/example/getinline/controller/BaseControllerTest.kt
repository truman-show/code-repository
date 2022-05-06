package com.example.getinline.controller

import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
class BaseControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `VIEW, GET 기본페이지 요청`() {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk)
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
            .andExpect(content().string(CoreMatchers.containsString("This is default Page.")))
            .andExpect(view().name("index"))
            .andDo(MockMvcResultHandlers.print())
    }

}
