package com.kmp.example.shared.domain.repository

import com.kmp.example.shared.data.result.Result
import com.kmp.example.shared.domain.model.Todo

/**
 * Repository interface for Todo operations.
 * This is the contract that data layer implements and domain layer uses.
 */
interface TodoRepository {
    /**
     * Fetches the title of a todo by its ID.
     * @param id The ID of the todo to fetch
     * @return Result containing the todo title or an error
     */
    suspend fun getTodoTitle(id: Int): Result<String>

    /**
     * Fetches a complete todo by its ID.
     * @param id The ID of the todo to fetch
     * @return Result containing the todo or an error
     */
    suspend fun getTodo(id: Int): Result<Todo>
}
