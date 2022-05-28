package com.example.getinline.dto

class APIDataResponse(
    success: Boolean,
    errorCode: Int,
    message: String,
    data: Any
) :
    APIErrorResponse(
        success,
        errorCode,
        message
    ) {
    var data: Any? = data

    companion object {
        fun of(success: Boolean, errorCode: Int, message: String, data: Any): APIDataResponse {
            return APIDataResponse(success, errorCode, message, data)
        }
    }
}
