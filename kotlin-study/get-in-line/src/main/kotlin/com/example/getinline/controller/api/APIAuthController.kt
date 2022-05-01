package com.example.getinline.controller.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
@RestController
class APIAuthController {

    @GetMapping("/sign-up")
    fun signUp(): String? {
        return "done."
    }

    @GetMapping("/login")
    fun login(): String? {
        return "done."
    }

}
