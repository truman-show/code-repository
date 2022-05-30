package com.example.getinline.controller.api

import com.example.getinline.dto.APIErrorResponse
import com.example.getinline.dto.APIErrorResponse.Companion.of
import com.example.getinline.exception.GeneralException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class APIEventController {

    @GetMapping("/events")
    fun getEvents(): List<String>? {
//        throw GeneralException("테스트 메세지")
        throw HttpRequestMethodNotSupportedException(
            "GET"
        )
//        return listOf("event1", "event2")
    }

    @PostMapping("/events")
    fun createEvent(): Boolean? {
        return true
    }

    @GetMapping("/events/{eventId}")
    fun getEvent(@PathVariable eventId: Int): String? {
        return "event $eventId"
    }

    @PutMapping("/events/{eventId}")
    fun modifyEvent(@PathVariable eventId: Int?): Boolean? {
        return true
    }

    @DeleteMapping("/events/{eventId}")
    fun removeEvent(@PathVariable eventId: Int?): Boolean? {
        return true
    }

    // APIEventController 의 핸들러 메소드들 중에서 GeneralException 예외가 발생했을 때 예외를 잡아 후처리를 한다
    @ExceptionHandler
    fun general(e: GeneralException): ResponseEntity<APIErrorResponse> {
        val errorCode = e.errorCode
        val status =
            if (errorCode.isClientSideError()) HttpStatus.BAD_REQUEST else HttpStatus.INTERNAL_SERVER_ERROR

        return ResponseEntity
            .status(status)
            .body(
                of(false, errorCode, errorCode.message(e))
            )
    }

}
