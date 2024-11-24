package com.space.learning.domain

class GetTodosUseCase(private val repository: TodoRepository) {
    fun getTodos(): List<TodoItem> {
        return repository.getTodos()
    }
}