package com.kmp.example.shared.domain.model

/**
 * Domain model for Todo.
 * This is the business logic representation, separate from API DTOs.
 */
data class Todo(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean
)
