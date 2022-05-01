package com.example.getinline.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthController {
    @GetMapping("/login")
    fun login(): String {
        return "auth/login"
    }

    @GetMapping("/sign-up")
    fun signUp(): String {
        return "auth/sign-up"
    }
}
