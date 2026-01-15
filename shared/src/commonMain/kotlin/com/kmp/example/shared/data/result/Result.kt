package com.kmp.example.shared.data.result

/**
 * A sealed class representing the result of an operation.
 * Can be either Success or Error.
 */
sealed class Result<out T> {
    /**
     * Success result containing data.
     */
    data class Success<T>(val data: T) : Result<T>()

    /**
     * Error result containing an error type and optional message.
     */
    data class Error(
        val error: ErrorType,
        val message: String? = null,
        val throwable: Throwable? = null
    ) : Result<Nothing>()

    /**
     * Returns true if this is a Success result.
     */
    val isSuccess: Boolean
        get() = this is Success

    /**
     * Returns true if this is an Error result.
     */
    val isError: Boolean
        get() = this is Error

    /**
     * Returns the data if Success, null otherwise.
     */
    fun getOrNull(): T? = when (this) {
        is Success -> data
        is Error -> null
    }

    /**
     * Returns the data if Success, or throws the error if Error.
     */
    fun getOrThrow(): T = when (this) {
        is Success -> data
        is Error -> throw throwable ?: Exception(message ?: "Unknown error")
    }

    /**
     * Returns the data if Success, or the default value if Error.
     */
    fun getOrDefault(defaultValue: T): T = when (this) {
        is Success -> data
        is Error -> defaultValue
    }

    /**
     * Maps the success value to a new value.
     */
    inline fun <R> map(transform: (T) -> R): Result<R> = when (this) {
        is Success -> Success(transform(data))
        is Error -> this
    }

    /**
     * Flat maps the success value to a new Result.
     */
    inline fun <R> flatMap(transform: (T) -> Result<R>): Result<R> = when (this) {
        is Success -> transform(data)
        is Error -> this
    }

    /**
     * Executes the given block if this is a Success.
     */
    inline fun onSuccess(block: (T) -> Unit): Result<T> {
        if (this is Success) block(data)
        return this
    }

    /**
     * Executes the given block if this is an Error.
     */
    inline fun onError(block: (Error) -> Unit): Result<T> {
        if (this is Error) block(this)
        return this
    }
}

/**
 * Types of errors that can occur in the application.
 */
enum class ErrorType {
    NETWORK,
    TIMEOUT,
    SERIALIZATION,
    UNKNOWN,
    NO_DATA
}
