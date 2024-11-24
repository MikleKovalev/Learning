package com.space.learning.data

import com.space.learning.domain.TodoItem
import com.space.learning.domain.TodoRepository
import java.lang.RuntimeException
import java.time.LocalDateTime
import java.util.Date

object InMemoryTodosRepository: TodoRepository {
    private val todos = mutableMapOf<Int, TodoItem>()
    private var autoIncrementId = 0

    init {
        val tmp = listOf(
            TodoItem("Task 1", "Task 1 description", LocalDateTime.now(), false),
            TodoItem("Task 2", "Task 2 description", LocalDateTime.now(), false),
            TodoItem("Task 3", "Task 3 description", LocalDateTime.now(), false),
            TodoItem("Task 4", "Task 4 description", LocalDateTime.now(), false),
            TodoItem("Task 5", "Task 5 description", LocalDateTime.now(), false),
            TodoItem("Task 6", "Task 6 description", LocalDateTime.now(), false),
        )
        tmp.forEach {
            add(it)
        }
    }

    override fun add(todo: TodoItem) {
        if (todo.id == TodoItem.UNDEFINED_ID) {
            todo.id = autoIncrementId++
        }
        todos[todo.id] = todo
    }

    override fun delete(todo: TodoItem) {
        todos.remove(todo.id, todo)
    }

    override fun edit(todo: TodoItem) {
        todos[todo.id] = todo
    }

    override fun getTodos(): List<TodoItem> {
        return todos.toList().map { (_, todoItem) ->
            todoItem
        }
    }

    override fun getTodoById(todoId: Int): TodoItem {
        return todos[todoId] ?: throw RuntimeException("No such item")
    }
}