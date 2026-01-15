package com.kmp.example.di

import com.kmp.example.shared.di.SharedModule
import com.kmp.example.shared.domain.repository.TodoRepository
import com.kmp.example.shared.domain.usecase.GetTodoTitleUseCase
import com.kmp.example.shared.domain.config.GetUrlUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedDependenciesModule {

    @Provides
    @Singleton
    fun provideGetUrlUseCase(): GetUrlUseCase {
        return SharedModule.provideGetUrlUseCase()
    }

    @Provides
    @Singleton
    fun provideTodoRepository(): TodoRepository {
        return SharedModule.provideTodoRepository()
    }

    @Provides
    @Singleton
    fun provideGetTodoTitleUseCase(): GetTodoTitleUseCase {
        return SharedModule.provideGetTodoTitleUseCase()
    }
}
