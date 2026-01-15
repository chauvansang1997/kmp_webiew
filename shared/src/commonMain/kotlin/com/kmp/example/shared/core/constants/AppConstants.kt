package com.kmp.example.shared.core.constants

/**
 * General application constants.
 */
object AppConstants {
    const val APP_NAME = "KMP WebView"
    const val APP_VERSION = "1.0.0"

    /**
     * Logging tags
     */
    object LogTags {
        const val NETWORK = "Network"
        const val WEBVIEW = "WebView"
        const val REPOSITORY = "Repository"
        const val VIEW_MODEL = "ViewModel"
    }

    /**
     * Error messages
     */
    object ErrorMessages {
        const val NETWORK_ERROR = "Network connection failed"
        const val TIMEOUT_ERROR = "Request timeout"
        const val UNKNOWN_ERROR = "An unknown error occurred"
        const val NO_DATA = "No data available"
    }
}
