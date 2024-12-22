package com.space.learning.presentation

import androidx.lifecycle.ViewModel
import com.space.learning.data.InMemoryTodosRepository
import com.space.learning.domain.AddTodoUseCase
import com.space.learning.domain.EditTodoUseCase
import com.space.learning.domain.GetTodoByIdUseCase
import com.space.learning.domain.TodoItem

class TodoViewModel: ViewModel() {
    private val repository = InMemoryTodosRepository
    private val getTodo = GetTodoByIdUseCase(repository)
    private val editTodo = EditTodoUseCase(repository)
    private val addTodo = AddTodoUseCase(repository)

    fun getTodoById(todoId: Int): TodoItem {
        return getTodo.getTodoById(todoId)
    }
}