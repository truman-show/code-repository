package com.example.getinline.controller.error

import com.example.getinline.constant.ErrorCode
import com.example.getinline.exception.GeneralException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView

@ControllerAdvice
class BaseExceptionHandler {

    @ExceptionHandler
    fun general(e: GeneralException): ModelAndView {
        val errorCode = e.errorCode
        val status =
            if (errorCode.isClientSideError()) HttpStatus.BAD_REQUEST else HttpStatus.INTERNAL_SERVER_ERROR

        return ModelAndView(
            "error",
            mapOf<String, Any>(
                "statusCode" to status.value(),
                "errorCode" to errorCode,
                "message" to errorCode.message(e)
            ),
            status
        )
    }

    @ExceptionHandler
    fun exception(e: Exception): ModelAndView {
        val errorCode = ErrorCode.INTERNAL_ERROR
        val status = HttpStatus.INTERNAL_SERVER_ERROR

        return ModelAndView(
            "error",
            mapOf<String, Any>(
                "statusCode" to status.value(),
                "errorCode" to errorCode,
                "message" to errorCode.message(e)
            ),
            status
        )
    }

}
