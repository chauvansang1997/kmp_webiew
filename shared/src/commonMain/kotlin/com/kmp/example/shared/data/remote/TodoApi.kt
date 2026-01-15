package com.kmp.example.shared.data.remote

import com.kmp.example.shared.core.constants.ApiConstants
import com.kmp.example.shared.data.model.TodoDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

/**
 * API interface for Todo operations.
 */
interface TodoApi {
    suspend fun getTodo(id: Int): TodoDto
}

/**
 * Implementation of TodoApi using Ktor client.
 */
class TodoApiImpl(private val httpClient: HttpClient) : TodoApi {
    override suspend fun getTodo(id: Int): TodoDto {
        return httpClient.get(ApiConstants.BASE_URL + ApiConstants.Endpoints.todoById(id))
            .body()
    }
}
