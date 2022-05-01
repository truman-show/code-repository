package com.example.getinline.controller

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BaseController : ErrorController {

    @GetMapping("/")
    fun root(): String {
        return "index"
    }

    @RequestMapping("/error")
    fun error(): String {
        return "error"
    }

}
