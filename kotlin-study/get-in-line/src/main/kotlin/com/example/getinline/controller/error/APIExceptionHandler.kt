package com.example.getinline.controller.error

import com.example.getinline.constant.ErrorCode
import com.example.getinline.dto.APIErrorResponse
import com.example.getinline.exception.GeneralException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice(annotations = [RestController::class])
class APIExceptionHandler {

    @ExceptionHandler
    fun general(e: GeneralException): ResponseEntity<APIErrorResponse> {
        val errorCode = e.errorCode
        val status =
            if (errorCode.isClientSideError()) HttpStatus.BAD_REQUEST else HttpStatus.INTERNAL_SERVER_ERROR

        return ResponseEntity
            .status(status)
            .body(
                APIErrorResponse.of(false, errorCode, errorCode.message(e))
            )
    }
    
    @ExceptionHandler
    fun exception(e: GeneralException): ResponseEntity<APIErrorResponse> {
        val errorCode = ErrorCode.INTERNAL_ERROR
        val status = HttpStatus.INTERNAL_SERVER_ERROR

        return ResponseEntity
            .status(status)
            .body(
                APIErrorResponse.of(false, errorCode, errorCode.message(e))
            )
    }

}
