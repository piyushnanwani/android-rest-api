package com.example.restapiex

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.restapiex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val todoViewModel: TodoViewModel by viewModels {
        TodoViewModelFactory(TodoRepository())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoViewModel.todos.observe(this, Observer { todos ->
            // Update the UI with the todos
            binding.todoItemsTextView.text = todos?.joinToString("\n") { it._id + "," + it.title + "," + it.description } ?: "No Todos"
        })

        todoViewModel.fetchTodos("reactjs", false)
    }
}
