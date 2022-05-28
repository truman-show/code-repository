package com.example.getinline.controller.error

import com.example.getinline.constant.ErrorCode
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletResponse

@Controller
class BaseErrorController : ErrorController {

    @RequestMapping("/error")
    fun error(response: HttpServletResponse): ModelAndView {
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
}
