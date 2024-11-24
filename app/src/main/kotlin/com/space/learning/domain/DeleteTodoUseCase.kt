package com.space.learning.domain

class DeleteTodoUseCase(private val repository: TodoRepository) {
    fun delete(todo: TodoItem) {
        repository.delete(todo)
    }
}