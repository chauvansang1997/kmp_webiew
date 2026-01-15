package com.kmp.example.shared.core.theme

/**
 * Shared color palette for the application.
 * These hex values can be used across both Android and iOS platforms.
 *
 * Colors are organized by purpose and include light/dark variants.
 */
object ColorPalette {

    /**
     * Primary brand colors
     */
    object Primary {
        const val DEFAULT = "#6200EE"          // Primary brand color
        const val VARIANT = "#3700B3"          // Darker variant
        const val LIGHT = "#9C4DFF"            // Lighter variant
    }

    /**
     * Secondary accent colors
     */
    object Secondary {
        const val DEFAULT = "#03DAC6"          // Secondary accent
        const val VARIANT = "#018786"          // Darker variant
        const val LIGHT = "#66FFF5"            // Lighter variant
    }

    /**
     * Background colors
     */
    object Background {
        const val LIGHT = "#FFFFFF"            // Light theme background
        const val DARK = "#121212"             // Dark theme background
        const val SURFACE_LIGHT = "#F5F5F5"    // Light theme surface
        const val SURFACE_DARK = "#1E1E1E"     // Dark theme surface
    }

    /**
     * Text colors
     */
    object Text {
        const val PRIMARY_LIGHT = "#000000"    // Primary text on light background
        const val PRIMARY_DARK = "#FFFFFF"     // Primary text on dark background
        const val SECONDARY_LIGHT = "#666666"  // Secondary text on light background
        const val SECONDARY_DARK = "#B3B3B3"   // Secondary text on dark background
        const val DISABLED_LIGHT = "#9E9E9E"   // Disabled text on light background
        const val DISABLED_DARK = "#616161"    // Disabled text on dark background
    }

    /**
     * Error and status colors
     */
    object Status {
        const val ERROR = "#B00020"            // Error state
        const val ERROR_DARK = "#CF6679"       // Error on dark background
        const val SUCCESS = "#4CAF50"          // Success state
        const val WARNING = "#FF9800"          // Warning state
        const val INFO = "#2196F3"             // Info state
    }

    /**
     * Neutral grays
     */
    object Neutral {
        const val GRAY_50 = "#FAFAFA"
        const val GRAY_100 = "#F5F5F5"
        const val GRAY_200 = "#EEEEEE"
        const val GRAY_300 = "#E0E0E0"
        const val GRAY_400 = "#BDBDBD"
        const val GRAY_500 = "#9E9E9E"
        const val GRAY_600 = "#757575"
        const val GRAY_700 = "#616161"
        const val GRAY_800 = "#424242"
        const val GRAY_900 = "#212121"
    }

    /**
     * Divider and border colors
     */
    object Divider {
        const val LIGHT = "#E0E0E0"            // Light theme divider
        const val DARK = "#424242"             // Dark theme divider
    }

    /**
     * Overlay and scrim colors (with alpha)
     */
    object Overlay {
        const val LIGHT = "#33000000"          // 20% black
        const val MEDIUM = "#66000000"         // 40% black
        const val DARK = "#99000000"           // 60% black
    }
}

/**
 * Helper function to convert hex color to integer (Android compatible).
 * Returns the color as an integer that can be used with Android's Color class.
 */
fun String.hexToColorInt(): Long {
    var colorString = this
    if (colorString.startsWith("#")) {
        colorString = colorString.substring(1)
    }

    // Add alpha if not present (FF = fully opaque)
    if (colorString.length == 6) {
        colorString = "FF$colorString"
    }

    return colorString.toLong(16)
}
