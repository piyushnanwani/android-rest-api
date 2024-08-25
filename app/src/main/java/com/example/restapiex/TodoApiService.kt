package com.example.restapiex

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TodoApiService {
    @GET("todos")
    suspend fun getTodos(
        @Query("query") query: String,
        @Query("complete") complete: Boolean
    ): Response<TodoResponse>

    @GET("todos/{id}")
    suspend fun getTodoById(
        @Path("id") id: String
    ): Response<Todo>

    @POST("todos")
    suspend fun createTodo(
        @Body todo: TodoCreateRequest
    ): Response<Todo>

    @DELETE("todos/{id}")
    suspend fun deleteTodo(
        @Path("id") id: String
    ): Response<Todo>
}
