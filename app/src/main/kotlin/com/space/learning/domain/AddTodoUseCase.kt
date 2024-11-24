package com.space.learning.domain

class AddTodoUseCase(private val repository: TodoRepository) {
    fun add(todo: TodoItem) {
        repository.add(todo)
    }
}