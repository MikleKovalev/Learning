package com.space.learning.domain

class GetTodoByIdUseCase(private val repository: TodoRepository) {
    fun getTodoById(todoId: Int): TodoItem {
        return repository.getTodoById(todoId)
    }
}