package com.kmp.example.core.constants

/**
 * Android-specific constants.
 */
object AndroidConstants {
    /**
     * WebView configuration
     */
    object WebView {
        const val ENABLE_JAVASCRIPT = true
        const val ENABLE_DOM_STORAGE = true
        const val ENABLE_ZOOM_CONTROLS = false
        const val DISPLAY_ZOOM_CONTROLS = false
    }

    /**
     * Toast duration in milliseconds
     */
    object Toast {
        const val DURATION_SHORT = 2000
        const val DURATION_LONG = 3500
    }

    /**
     * View-related constants
     */
    object View {
        const val FADE_DURATION = 300L
    }
}
