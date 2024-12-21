package com.space.learning.presentation

import androidx.lifecycle.ViewModel
import com.space.learning.data.InMemoryTodosRepository
import com.space.learning.domain.AddTodoUseCase
import com.space.learning.domain.EditTodoUseCase
import com.space.learning.domain.GetTodoByIdUseCase

class TodoViewModel: ViewModel() {
    private val repository = InMemoryTodosRepository
    private val getTodo = GetTodoByIdUseCase(repository)
    private val editTodo = EditTodoUseCase(repository)
    private val addTodo = AddTodoUseCase(repository)


}