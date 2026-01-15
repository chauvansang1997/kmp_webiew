package com.kmp.example.shared.di

import com.kmp.example.shared.core.network.HttpClientProvider
import com.kmp.example.shared.core.config.NetworkConfig
import com.kmp.example.shared.data.remote.TodoApi
import com.kmp.example.shared.data.remote.TodoApiImpl
import com.kmp.example.shared.data.repository.TodoRepositoryImpl

import com.kmp.example.shared.domain.repository.TodoRepository
import com.kmp.example.shared.domain.usecase.GetTodoTitleUseCase
import com.kmp.example.shared.domain.usecase.GetUrlUseCase

import io.ktor.client.HttpClient

object SharedModule {

    private val networkConfig: NetworkConfig by lazy { NetworkConfig() }
    private val httpClient: HttpClient by lazy { HttpClientProvider.getClient(networkConfig) }

    private val todoApi: TodoApi by lazy { TodoApiImpl(httpClient) }
    private val todoRepository: TodoRepository by lazy { TodoRepositoryImpl(todoApi) }


    private val getTodoTitleUseCase: GetTodoTitleUseCase by lazy { GetTodoTitleUseCase(todoRepository) }
    private val getUrlUseCase: GetUrlUseCase by lazy { GetUrlUseCase() }

    fun provideTodoRepository(): TodoRepository = todoRepository
    fun provideGetTodoTitleUseCase(): GetTodoTitleUseCase = getTodoTitleUseCase
    fun provideGetUrlUseCase(): GetUrlUseCase = getUrlUseCase
    fun provideHttpClient(): HttpClient = httpClient
}
