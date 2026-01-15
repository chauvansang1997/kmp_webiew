package com.kmp.example.shared.data.result

import com.kmp.example.shared.core.constants.AppConstants

/**
 * Wraps a suspend function call in a Result.
 */
suspend inline fun <T> resultOf(block: suspend () -> T): Result<T> {
    return try {
        Result.Success(block())
    } catch (e: Exception) {
        Result.Error(
            error = determineErrorType(e),
            message = e.message ?: AppConstants.ErrorMessages.UNKNOWN_ERROR,
            throwable = e
        )
    }
}

/**
 * Determines the error type from an exception.
 */
fun determineErrorType(exception: Exception): ErrorType {
    return when {
        exception::class.simpleName?.contains("Timeout", ignoreCase = true) == true -> ErrorType.TIMEOUT
        exception::class.simpleName?.contains("IO", ignoreCase = true) == true -> ErrorType.NETWORK
        exception::class.simpleName?.contains("Serialization", ignoreCase = true) == true -> ErrorType.SERIALIZATION
        else -> ErrorType.UNKNOWN
    }
}
