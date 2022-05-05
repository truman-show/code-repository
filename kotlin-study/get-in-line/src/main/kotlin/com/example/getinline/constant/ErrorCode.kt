package com.example.getinline.constant

import java.lang.String.format

enum class ErrorCode(val code: Int, val errorCategory: ErrorCategory, val message: String) {

    OK(0, ErrorCategory.NORMAL, "Ok"),

    BAD_REQUEST(10000, ErrorCategory.CLIENT_SIDE, "bad request"),
    SPRING_BAD_REQUEST(10001, ErrorCategory.CLIENT_SIDE, "Spring-detected bad request"),

    INTERNAL_ERROR(20000, ErrorCategory.SERVER_SIDE, "internal error"),
    SPRING_INTERNAL_ERROR(20001, ErrorCategory.SERVER_SIDE, "Spring-detected internal error");

    fun getMessage(e: Throwable): String {
        return this.getMessage(message + " - " + e.message)
    }

    fun getMessage(message: String?): String {
        return message ?: ""
    }


    fun isClientSideError(): Boolean {
        return errorCategory == ErrorCategory.CLIENT_SIDE
    }

    fun isServerSideError(): Boolean {
        return errorCategory == ErrorCategory.SERVER_SIDE
    }

    override fun toString(): String {
        return format("%s (%d)", name, code)
    }

    enum class ErrorCategory {
        NORMAL, CLIENT_SIDE, SERVER_SIDE
    }

}