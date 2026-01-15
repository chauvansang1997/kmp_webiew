package com.kmp.example.shared.domain.repository

import com.kmp.example.shared.data.result.Result
import com.kmp.example.shared.domain.model.Todo

interface TodoRepository {
    suspend fun getTodoTitle(id: Int): Result<String>

    suspend fun getTodo(id: Int): Result<Todo>
}
