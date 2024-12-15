package com.space.learning.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.space.learning.data.InMemoryTodosRepository
import com.space.learning.domain.DeleteTodoUseCase
import com.space.learning.domain.EditTodoUseCase
import com.space.learning.domain.GetTodosUseCase
import com.space.learning.domain.TodoItem

class MainViewModel: ViewModel() {
    private val repository = InMemoryTodosRepository
    private val getTodos = GetTodosUseCase(repository)
    private val editTodos = EditTodoUseCase(repository)
    private val deleteTodos = DeleteTodoUseCase(repository)

    val todos = MutableLiveData<List<TodoItem>>()

    fun getTodos() {
        val list = getTodos.getTodos()
        todos.postValue(list)
    }

    fun deleteTodo(todoItem: TodoItem) {
        deleteTodos.delete(todoItem)
        val list = getTodos.getTodos()
        todos.postValue(list)
    }
}