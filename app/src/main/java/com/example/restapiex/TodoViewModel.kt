package com.example.restapiex

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    private val _todos = MutableLiveData<List<Todo>?>()

    val todos: LiveData<List<Todo>?> get() = _todos

    private val _todo = MutableLiveData<Todo?>()
    val todo: MutableLiveData<Todo?> get() = _todo

    private val _newTodo = MutableLiveData<Todo?>()
    val newTodo: MutableLiveData<Todo?> get() = _newTodo

    // write function to fetch todos from TodoRepository
    fun fetchTodos(query: String, complete: Boolean) {
        viewModelScope.launch {
            val result = repository.getTodos(query, complete)
             _todos.value = result?.data
        }
    }

    fun fetchTodoById(id: String) {
        viewModelScope.launch {
            val result = repository.getTodoById(id)
            _todo.value = result
        }
    }

    fun createTodo(todo: TodoCreateRequest) {
        viewModelScope.launch {
            val result = repository.createTodo(todo)
            _newTodo.value = result
        }
    }

    override fun onCleared() {
        super.onCleared()
        _todos.value = null
        _todo.value = null
        _newTodo.value = null
    }
    override fun toString(): String {
        return "TodoViewModel(repository=$repository, todos=$todos, todo=$todo, newTodo=$newTodo)"
    }
}
