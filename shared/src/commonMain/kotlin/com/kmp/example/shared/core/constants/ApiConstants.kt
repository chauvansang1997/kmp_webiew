package com.kmp.example.shared.core.constants

/**
 * API-related constants used across the application.
 */
object ApiConstants {
    /**
     * Base URL for JSONPlaceholder API
     */
    const val BASE_URL = "https://jsonplaceholder.typicode.com"

    /**
     * API endpoints
     */
    object Endpoints {
        const val TODOS = "/todos"

        fun todoById(id: Int) = "$TODOS/$id"
    }

    /**
     * Default timeout values in milliseconds
     */
    object Timeouts {
        const val CONNECT_TIMEOUT = 15_000L
        const val READ_TIMEOUT = 15_000L
        const val WRITE_TIMEOUT = 15_000L
    }

    /**
     * HTTP Headers
     */
    object Headers {
        const val CONTENT_TYPE = "Content-Type"
        const val ACCEPT = "Accept"
        const val APPLICATION_JSON = "application/json"
    }
}
