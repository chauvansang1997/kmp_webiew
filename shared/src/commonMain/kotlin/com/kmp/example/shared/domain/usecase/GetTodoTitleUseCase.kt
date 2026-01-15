package com.kmp.example.shared.domain.usecase

import com.kmp.example.shared.data.result.Result
import com.kmp.example.shared.domain.repository.TodoRepository

/**
 * Use case for fetching a todo title.
 * Encapsulates the business logic for this specific operation.
 */
class GetTodoTitleUseCase(
    private val todoRepository: TodoRepository
) {
    /**
     * Executes the use case to fetch a todo title.
     * @param todoId The ID of the todo to fetch (defaults to 1)
     * @return Result containing the todo title or an error
     */
    suspend fun execute(todoId: Int = 1): Result<String> {
        return todoRepository.getTodoTitle(todoId)
    }
}
