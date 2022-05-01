package com.example.getinline.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin")
class AdminController {

    @GetMapping("/places")
    fun adminPlaces(): String {
        return "admin/places"
    }

    @GetMapping("/places/{placeId}")
    fun adminPlaceDetail(@PathVariable placeId: Int?): String {
        return "admin/place-detail"
    }

    @GetMapping("/events")
    fun adminEvents(): String {
        return "admin/events"
    }

    @GetMapping("/events/{eventId}")
    fun adminEventDetail(@PathVariable eventId: Int?): String {
        return "admin/event-detail"
    }

}
