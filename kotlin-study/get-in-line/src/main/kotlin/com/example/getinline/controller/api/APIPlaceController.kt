package com.example.getinline.controller.api

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class APIPlaceController {

    @GetMapping("/places")
    fun getPlaces(): List<String>? {
        return java.util.List.of("place1", "place2")
    }

    @PostMapping("/places")
    fun createPlace(): Boolean? {
        return true
    }

    @GetMapping("/places/{placeId}")
    fun getPlace(@PathVariable placeId: Int): String? {
        return "place $placeId"
    }

    @PutMapping("/places/{placeId}")
    fun modifyPlace(@PathVariable placeId: Int?): Boolean? {
        return true
    }

    @DeleteMapping("/places/{placeId}")
    fun removePlace(@PathVariable placeId: Int?): Boolean? {
        return true
    }

}
