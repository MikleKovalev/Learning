package com.space.learning.domain

import java.time.LocalDateTime

data class TodoItem(
    val header: String,
    val content: String,
    val createdAt: LocalDateTime,
    val done: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = -1
    }
}