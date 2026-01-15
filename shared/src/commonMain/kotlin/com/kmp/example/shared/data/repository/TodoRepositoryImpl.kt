package com.kmp.example.shared.data.repository

import com.kmp.example.shared.core.constants.AppConstants
import com.kmp.example.shared.data.result.Result
import com.kmp.example.shared.data.result.resultOf
import com.kmp.example.shared.core.util.LoggerProvider
import com.kmp.example.shared.data.remote.TodoApi
import com.kmp.example.shared.domain.model.Todo
import com.kmp.example.shared.domain.repository.TodoRepository

/**
 * Implementation of TodoRepository.
 * Handles data operations and mapping between DTOs and domain models.
 */
class TodoRepositoryImpl(
    private val todoApi: TodoApi
) : TodoRepository {

    private val logger = LoggerProvider.getLogger()

    override suspend fun getTodoTitle(id: Int): Result<String> {
        logger.debug(AppConstants.LogTags.REPOSITORY, "Fetching todo with id: $id")

        return resultOf {
            val todoDto = todoApi.getTodo(id)
            logger.info(AppConstants.LogTags.REPOSITORY, "Todo fetched successfully: ${todoDto.title}")
            todoDto.title
        }
    }

    override suspend fun getTodo(id: Int): Result<Todo> {
        logger.debug(AppConstants.LogTags.REPOSITORY, "Fetching todo with id: $id")

        return resultOf {
            val todoDto = todoApi.getTodo(id)
            logger.info(AppConstants.LogTags.REPOSITORY, "Todo fetched successfully")

            Todo(
                id = todoDto.id,
                userId = todoDto.userId,
                title = todoDto.title,
                completed = todoDto.completed
            )
        }
    }
}
