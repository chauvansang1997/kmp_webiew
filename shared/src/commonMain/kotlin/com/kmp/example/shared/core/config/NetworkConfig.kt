package com.kmp.example.shared.core.config

import com.kmp.example.shared.core.constants.ApiConstants

/**
 * Network configuration for HTTP client setup.
 */
data class NetworkConfig(
    val baseUrl: String = ApiConstants.BASE_URL,
    val connectTimeout: Long = ApiConstants.Timeouts.CONNECT_TIMEOUT,
    val readTimeout: Long = ApiConstants.Timeouts.READ_TIMEOUT,
    val writeTimeout: Long = ApiConstants.Timeouts.WRITE_TIMEOUT,
    val enableLogging: Boolean = true
)
