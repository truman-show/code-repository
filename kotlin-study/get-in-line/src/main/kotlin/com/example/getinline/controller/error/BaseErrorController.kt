package com.example.getinline.controller.error

import com.example.getinline.constant.ErrorCode
import com.example.getinline.dto.APIErrorResponse
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse

@Controller
class BaseErrorController : ErrorController {

    @RequestMapping("/error", produces = [MediaType.TEXT_HTML_VALUE])
    fun errorHtml(response: HttpServletResponse): ModelAndView {
        val status = HttpStatus.valueOf(response.status)
        val errorCode =
            if (status.is4xxClientError) ErrorCode.BAD_REQUEST else ErrorCode.INTERNAL_ERROR

        return ModelAndView(
            "error",
            mapOf<String, Any>(
                "statusCode" to status.value(),
                "errorCode" to errorCode,
                "message" to errorCode.message(status.reasonPhrase)
            ),
            status
        )
    }

    @RequestMapping("/error")
    fun error(response: HttpServletResponse): ResponseEntity<APIErrorResponse> {
        val status = HttpStatus.valueOf(response.status)
        val errorCode =
            if (status.is4xxClientError) ErrorCode.BAD_REQUEST else ErrorCode.INTERNAL_ERROR

        return ResponseEntity
            .status(status)
            .body(APIErrorResponse.of(false, errorCode))
    }

}
