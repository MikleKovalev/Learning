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
        repeat(20) {
            add(
                TodoItem(
                "Task $it",
                "Task $it description",
                LocalDateTime.now(),
                    false)
            )
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