package com.example.getinline.controller.error

import com.example.getinline.constant.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class BaseExceptionHandler {

    @ExceptionHandler
    fun exception(e: Exception, response: HttpServletResponse): ModelAndView? {
        var httpStatus = HttpStatus.valueOf(response.status)
        var errorCode: ErrorCode =
            if (httpStatus.is4xxClientError) ErrorCode.BAD_REQUEST else ErrorCode.INTERNAL_ERROR
        if (httpStatus == HttpStatus.OK) {
            httpStatus = HttpStatus.FORBIDDEN
            errorCode = ErrorCode.BAD_REQUEST
        }
        return ModelAndView(
            "error",
            mapOf(
                "statusCode" to httpStatus.value(),
                "errorCode" to errorCode,
                "message" to errorCode.getMessage(e)
            ),
            httpStatus
        )
    }
}