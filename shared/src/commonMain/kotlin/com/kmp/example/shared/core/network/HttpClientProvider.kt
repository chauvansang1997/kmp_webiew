package com.kmp.example.shared.core.network

import com.kmp.example.shared.core.config.NetworkConfig
import com.kmp.example.shared.core.constants.ApiConstants
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Provides a configured HttpClient instance for network operations.
 */
object HttpClientProvider {

    private var _client: HttpClient? = null

    /**
     * Get or create the HttpClient instance.
     */
    fun getClient(config: NetworkConfig = NetworkConfig()): HttpClient {
        return _client ?: createClient(config).also { _client = it }
    }

    /**
     * Create a new HttpClient with the given configuration.
     */
    private fun createClient(config: NetworkConfig): HttpClient {
        return HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        isLenient = true
                        encodeDefaults = true
                        prettyPrint = true
                    }
                )
            }

            install(HttpTimeout) {
                requestTimeoutMillis = config.readTimeout
                connectTimeoutMillis = config.connectTimeout
                socketTimeoutMillis = config.writeTimeout
            }

            if (config.enableLogging) {
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.INFO
                }
            }

            defaultRequest {
                header(ApiConstants.Headers.CONTENT_TYPE, ApiConstants.Headers.APPLICATION_JSON)
                header(ApiConstants.Headers.ACCEPT, ApiConstants.Headers.APPLICATION_JSON)
            }
        }
    }
}
