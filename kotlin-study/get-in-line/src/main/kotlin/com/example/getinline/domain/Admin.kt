package com.example.getinline.domain

import java.time.LocalDateTime

data class Admin(
    val id: Long, val email: String, val nickname: String,
    val password: String, val phoneNumber: String, val memo: String,
    val createdAt: LocalDateTime, val modifiedAt: LocalDateTime
)
