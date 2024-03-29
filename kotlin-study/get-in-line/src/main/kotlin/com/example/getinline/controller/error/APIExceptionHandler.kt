package com.example.getinline.controller.error

import com.example.getinline.constant.ErrorCode
import com.example.getinline.exception.GeneralException
import com.example.getinline.response.APIErrorResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice(annotations = [RestController::class])
class APIExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler
    fun general(e: GeneralException, request: WebRequest): ResponseEntity<Any> {
        val errorCode = e.errorCode
        val status =
            if (errorCode.isClientSideError()) HttpStatus.BAD_REQUEST else HttpStatus.INTERNAL_SERVER_ERROR

        return super.handleExceptionInternal(
            e,
            APIErrorResponse.of(false, errorCode.code, errorCode.message),
            HttpHeaders.EMPTY,
            status,
            request
        )
    }

    @ExceptionHandler
    fun exception(
        e: Exception,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorCode = ErrorCode.INTERNAL_ERROR
        val status = HttpStatus.INTERNAL_SERVER_ERROR

        return super.handleExceptionInternal(
            e,
            APIErrorResponse.of(false, errorCode.code, errorCode.message),
            HttpHeaders.EMPTY,
            status,
            request
        )
    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val errorCode = if (status.is4xxClientError)
            ErrorCode.SPRING_BAD_REQUEST else ErrorCode.SPRING_INTERNAL_ERROR

        return super.handleExceptionInternal(
            ex,
            APIErrorResponse.of(false, errorCode.code, errorCode.message),
            headers,
            status,
            request
        )

    }
}
