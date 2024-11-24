package com.space.learning.domain

import java.util.Date

data class TodoItem(
    val id: Int,
    val header: String,
    val content: String,
    val createdAt: Date,
    val done: Boolean
)