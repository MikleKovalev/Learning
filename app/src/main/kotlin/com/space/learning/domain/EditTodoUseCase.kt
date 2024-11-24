package com.space.learning.domain

class EditTodoUseCase(private val repository: TodoRepository) {
    fun edit(todo: TodoItem) {
        repository.edit(todo)
    }
}