package com.example.getinline.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/events")
class EventController {

    @GetMapping("/")
    fun events(): String {
        return "event/index"
    }

    @GetMapping("/{eventId}")
    fun eventDetail(@PathVariable eventId: Int?): String {
        return "event/detail"
    }

}
