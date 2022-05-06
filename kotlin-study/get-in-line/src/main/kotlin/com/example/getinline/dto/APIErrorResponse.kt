package com.example.getinline.dto

import com.example.getinline.constant.ErrorCode

data class APIErrorResponse(val success: Boolean, val errorCode: Int, val message: String) {

    companion object {
        fun of(success: Boolean, errorCode: Int, message: String): APIErrorResponse {
            return APIErrorResponse(success, errorCode, message)
        }

        fun of(success: Boolean, errorCode: ErrorCode): APIErrorResponse {
            return APIErrorResponse(success, errorCode.code, errorCode.message)
        }

        fun of(success: Boolean, errorCode: ErrorCode, exception: Exception): APIErrorResponse {
            return APIErrorResponse(
                success,
                errorCode.code,
                errorCode.getMessage(exception.message)
            )
        }

        fun of(success: Boolean, errorCode: ErrorCode, message: String): APIErrorResponse {
            return APIErrorResponse(
                success,
                errorCode.code,
                errorCode.getMessage(message)
            )
        }
    }


}