package com.kmp.example.shared.core.constants

/**
 * WebView-related constants used across platforms.
 */
object WebViewConstants {
    /**
     * Default WebView URL
     */
    const val DEFAULT_URL = "https://sgcarmart.com"

    /**
     * WebView configuration
     */
    object Config {
        const val ENABLE_JAVASCRIPT = true
        const val ENABLE_DOM_STORAGE = true
        const val CACHE_MODE_DEFAULT = "LOAD_DEFAULT"
    }
}
