package com.kmp.example.shared.domain.usecase

import com.kmp.example.shared.data.result.Result
import com.kmp.example.shared.domain.repository.TodoRepository

class GetTodoTitleUseCase(
    private val todoRepository: TodoRepository
) {
    suspend fun execute(todoId: Int = 1): Result<String> {
        return todoRepository.getTodoTitle(todoId)
    }
}
