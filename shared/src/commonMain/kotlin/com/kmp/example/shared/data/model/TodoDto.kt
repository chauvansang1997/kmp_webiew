package com.kmp.example.shared.data.model

import kotlinx.serialization.Serializable

/**
 * Data Transfer Object for Todo API response.
 */
@Serializable
data class TodoDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
