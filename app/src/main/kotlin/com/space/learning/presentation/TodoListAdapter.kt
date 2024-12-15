package com.space.learning.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.space.learning.databinding.TodoItemBinding
import com.space.learning.domain.TodoItem

class TodoListAdapter : ListAdapter<TodoItem, TodoListAdapter.TodoViewHolder>(TodoItemDiffCallback()) {
    var count = 0
    var onTodoLongClickListener: ((TodoItem) -> Unit)? = null

    class TodoViewHolder(
        private val binding: TodoItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: TodoItem, listener: ((TodoItem) -> Unit)?) {
            binding.headerTextView.text = todo.header
            binding.shortDescriptionTextView.text = todo.content
            binding.root.setOnLongClickListener {
                listener?.invoke(todo)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = TodoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        Log.d("CREATE NEW VIEW", "${++count}")
        return TodoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position), onTodoLongClickListener)
    }
}