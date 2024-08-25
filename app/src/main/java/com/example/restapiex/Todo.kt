package com.example.restapiex

data class Todo(
    val _id: String,
    val title: String,
    val description: String?,
    val isComplete: Boolean
)

data class TodoCreateRequest(
    val title: String,
    val description: String? = null
)

data class TodoResponse(
    val statusCode: Int,
    val data: List<Todo>,
    val message: String,
    val success: Boolean
)
