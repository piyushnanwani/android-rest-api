package com.example.restapiex

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepository {

    suspend fun getTodos(query: String, complete: Boolean): TodoResponse? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getTodos(query, complete)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun getTodoById(id: String): Todo? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getTodoById(id)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }

    suspend fun createTodo(todo: TodoCreateRequest): Todo? {
        return withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.createTodo(todo)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        }
    }
}
