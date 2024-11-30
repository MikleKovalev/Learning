package com.space.learning.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.space.learning.databinding.TodoItemBinding
import com.space.learning.domain.TodoItem

class TodoListAdapter : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {
    var todos = listOf<TodoItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class TodoViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: TodoItem) {
            binding.headerTextView.text = todo.header
            binding.shortDescriptionTextView.text = todo.content
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TodoViewHolder(binding)
    }

    override fun getItemCount(): Int = todos.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }
}