package com.example.getinline.exception

import com.example.getinline.constant.ErrorCode

class GeneralException : RuntimeException {
    private val errorCode: ErrorCode

    constructor() : super(ErrorCode.INTERNAL_ERROR.message) {
        errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(message: String?) : super(ErrorCode.INTERNAL_ERROR.getMessage(message)) {
        errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(message: String?, cause: Throwable?) : super(
        ErrorCode.INTERNAL_ERROR.getMessage(
            message
        ), cause
    ) {
        errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(cause: Throwable) : super(ErrorCode.INTERNAL_ERROR.getMessage(cause)) {
        errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(errorCode: ErrorCode) : super(errorCode.message) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCode, message: String?) : super(errorCode.getMessage(message)) {
        this.errorCode = errorCode
    }

    constructor(
        errorCode: ErrorCode,
        message: String?,
        cause: Throwable?
    ) : super(errorCode.getMessage(message), cause) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCode, cause: Throwable) : super(
        errorCode.getMessage(cause),
        cause
    ) {
        this.errorCode = errorCode
    }
}