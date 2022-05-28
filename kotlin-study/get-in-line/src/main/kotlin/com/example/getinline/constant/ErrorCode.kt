package com.example.getinline.constant

enum class ErrorCode(
    val code: Int, val errorCategory: ErrorCategory, val message: String
) {


    OK(0, ErrorCategory.CLIENT_SIDE, "OK"),
    BAD_REQUEST(10000, ErrorCategory.CLIENT_SIDE, "bad request"),
    SPRING_BAD_REQUEST(10001, ErrorCategory.CLIENT_SIDE, "Spring-detected bad request"),

    INTERNAL_ERROR(20000, ErrorCategory.SERVER_SIDE, "internal error"),
    SPRING_INTERNAL_ERROR(20001, ErrorCategory.SERVER_SIDE, "Spring-detected internal error")
    ;

    fun message(e: Exception): String = this.message(e.message)

    fun message(message: String?): String = if (message.isNullOrEmpty()) this.message else message

    fun isClientSideError(): Boolean = this.errorCategory == ErrorCategory.CLIENT_SIDE

    fun isServerSideError(): Boolean = this.errorCategory == ErrorCategory.SERVER_SIDE

    enum class ErrorCategory {
        NOMAL, CLIENT_SIDE, SERVER_SIDE
    }
}



