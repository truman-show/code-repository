package com.example.getinline.response

import com.example.getinline.constant.ErrorCode

class APIDataResponse<T>(
    var data: T?
) : APIErrorResponse(
    success = true,
    errorCode = ErrorCode.OK.code,
    message = ErrorCode.OK.message
) {

    companion object {
        fun <T> of(data: T?): APIDataResponse<T> {
            return APIDataResponse(data)
        }
    }
}
