package com.kmp.example.shared.core.util

/**
 * Platform-agnostic logger interface.
 * Implementations should be provided for each platform.
 */
interface Logger {
    fun debug(tag: String, message: String)
    fun info(tag: String, message: String)
    fun warn(tag: String, message: String)
    fun error(tag: String, message: String, throwable: Throwable? = null)
}

/**
 * Simple console logger implementation for common code.
 */
class ConsoleLogger : Logger {
    override fun debug(tag: String, message: String) {
        println("DEBUG [$tag]: $message")
    }

    override fun info(tag: String, message: String) {
        println("INFO [$tag]: $message")
    }

    override fun warn(tag: String, message: String) {
        println("WARN [$tag]: $message")
    }

    override fun error(tag: String, message: String, throwable: Throwable?) {
        println("ERROR [$tag]: $message")
        throwable?.let { println(it.stackTraceToString()) }
    }
}

/**
 * Global logger instance.
 */
object LoggerProvider {
    private var logger: Logger = ConsoleLogger()

    fun setLogger(logger: Logger) {
        this.logger = logger
    }

    fun getLogger(): Logger = logger
}
