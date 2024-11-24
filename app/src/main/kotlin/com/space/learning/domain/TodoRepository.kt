package com.space.learning.domain

interface TodoRepository {
    fun add(todo: TodoItem)
    fun delete(todo: TodoItem)
    fun edit(todo: TodoItem)
    fun getTodos(): List<TodoItem>
    fun getTodoById(todoId: Int): TodoItem
}