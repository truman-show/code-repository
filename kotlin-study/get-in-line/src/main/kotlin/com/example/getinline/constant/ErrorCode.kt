package com.example.getinline.constant

import com.example.getinline.exception.GeneralException
import org.springframework.http.HttpStatus
import java.lang.String.format
import java.util.*

enum class ErrorCode(val code: Int, val httpStatus: HttpStatus, val message: String) {


    OK(0, HttpStatus.OK, "Ok"),

    BAD_REQUEST(10000, HttpStatus.BAD_REQUEST, "Bad request"),
    SPRING_BAD_REQUEST(10001, HttpStatus.BAD_REQUEST, "Spring-detected bad request"),
    VALIDATION_ERROR(10002, HttpStatus.BAD_REQUEST, "Validation error"),
    NOT_FOUND(10003, HttpStatus.NOT_FOUND, "Requested resource is not found"),

    INTERNAL_ERROR(20000, HttpStatus.INTERNAL_SERVER_ERROR, "Internal error"),
    SPRING_INTERNAL_ERROR(
        20001,
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Spring-detected internal error"
    ),
    DATA_ACCESS_ERROR(20002, HttpStatus.INTERNAL_SERVER_ERROR, "Data access error");

    fun getMessage(e: Throwable): String {
        return this.getMessage(message + " - " + e.message)
    }


    fun getMessage(message: String): String {
        return message
    }

    override fun toString(): String {
        return format("%s (%d)", name, code)
    }


    companion object {
        fun valueOf(httpStatus: HttpStatus?): ErrorCode {
            if (httpStatus == null) {
                throw GeneralException("HttpStatus is null.")
            }

            return Arrays.stream(values())
                .filter { errorCode: ErrorCode -> errorCode.httpStatus === httpStatus }
                .findFirst()
                .orElseGet {
                    if (httpStatus.is4xxClientError) {
                        return@orElseGet BAD_REQUEST
                    } else if (httpStatus.is5xxServerError) {
                        return@orElseGet INTERNAL_ERROR
                    } else {
                        return@orElseGet OK
                    }
                }
        }
    }
}