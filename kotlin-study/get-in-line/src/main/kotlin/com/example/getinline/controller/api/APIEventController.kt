package com.example.getinline.controller.api

import com.example.getinline.exception.GeneralException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class APIEventController {

    @GetMapping("/events")
    fun getEvents(): List<String>? {
        throw HttpRequestMethodNotSupportedException("스프링 예외 테스트")
//        return listOf("event1", "event2")
    }

    @PostMapping("/events")
    fun createEvent(): Boolean? {
        return true
    }

    @GetMapping("/events/{eventId}")
    fun getEvent(@PathVariable eventId: Int): String? {
        throw GeneralException("General 예외 테스트 ")
//        return "event $eventId"
    }

    @PutMapping("/events/{eventId}")
    fun modifyEvent(@PathVariable eventId: Int?): Boolean? {
        return true
    }

    @DeleteMapping("/events/{eventId}")
    fun removeEvent(@PathVariable eventId: Int?): Boolean? {
        return true
    }
}
