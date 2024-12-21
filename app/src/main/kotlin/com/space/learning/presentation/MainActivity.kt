package com.space.learning.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.space.learning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var todosAdapter: TodoListAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        setupRecyclerView()
        setupActionButton()
    }

    private fun setupRecyclerView() {
        todosAdapter = TodoListAdapter()
        binding.todosRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.todosRecyclerView.adapter = todosAdapter
        viewModel.todos.observe(this) {
            todosAdapter.submitList(it)
        }
        todosAdapter.onTodoLongClickListener = {

        }
        val callback = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val todo = todosAdapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteTodo(todo)
            }
        }
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(binding.todosRecyclerView)
        viewModel.getTodos()
    }

    private fun setupActionButton() {

    }
}