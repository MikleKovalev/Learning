package com.space.learning.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
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
        viewModel.todos.observe(this) {
            todosAdapter.todos = it
        }
        viewModel.getTodos()
    }

    private fun setupRecyclerView() {
        todosAdapter = TodoListAdapter()
        binding.todosRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.todosRecyclerView.adapter = todosAdapter
    }
}