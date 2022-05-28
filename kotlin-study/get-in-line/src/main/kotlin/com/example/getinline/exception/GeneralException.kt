package com.example.getinline.exception

import com.example.getinline.constant.ErrorCode

class GeneralException : RuntimeException {

    var errorCode: ErrorCode

    constructor() : super() {
        this.errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(message: String) : super(message) {
        this.errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(message: String, cause: Throwable) : super(message, cause) {
        this.errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(cause: Throwable) : super(cause) {
        this.errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(
        message: String,
        cause: Throwable,
        enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) : super(message, cause, enableSuppression, writableStackTrace) {
        this.errorCode = ErrorCode.INTERNAL_ERROR
    }

    constructor(
        errorCode: ErrorCode
    ) : super(errorCode.message) {
        this.errorCode = errorCode
    }

    constructor (
        errorCode: ErrorCode, cause: Throwable?
    ) : super(errorCode.message, cause) {
        this.errorCode = errorCode
    }

    constructor (
        errorCode: ErrorCode,
        cause: Throwable?,
        enableSuppression: Boolean,
        writableStackTrace: Boolean
    ) : super(errorCode.message, cause, enableSuppression, writableStackTrace) {
        this.errorCode = ErrorCode.INTERNAL_ERROR
    }


}
