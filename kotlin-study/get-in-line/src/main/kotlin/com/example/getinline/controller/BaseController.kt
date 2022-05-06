package com.example.getinline.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BaseController {

    @GetMapping("/")
    fun root(): String {
        return "index"
    }

}
