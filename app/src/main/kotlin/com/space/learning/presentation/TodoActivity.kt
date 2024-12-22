package com.space.learning.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.space.learning.databinding.ActivityTodoBinding

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding
    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[TodoViewModel::class.java]
        setupTodo()
    }

    private fun setupTodo() {
        when (intent.getStringExtra(MODE) ?: MODE_ADD) {
            MODE_EDIT -> {
                val id = (intent.getStringExtra(TODO_ID) ?: "-1").toInt()
                val todo = viewModel.getTodoById(id)
                binding.titleEditText.setText(todo.header.toCharArray(), 0, todo.header.length)
                binding.contentEditText.setText(
                    todo.content.toCharArray(),
                    0,
                    todo.content.length
                )
            }
        }
    }

    companion object {
        private const val MODE = "MODE"
        private const val MODE_ADD = "MODE_ADD"
        private const val MODE_EDIT = "MODE_EDIT"
        private const val TODO_ID = "TODO_ID"

        fun newIntentAddTodo(context: Context): Intent {
            val intent = Intent(context, TodoActivity::class.java)
            intent.putExtra(MODE, MODE_ADD)
            return intent
        }

        fun newIntentEditTodo(context: Context, todoId: Int): Intent {
            val intent = Intent(context, TodoActivity::class.java)
            intent.putExtra(MODE, MODE_EDIT)
            intent.putExtra(TODO_ID, todoId)
            return intent
        }
    }
}