package com.kmp.example.shared.core.theme

/**
 * Shared theme constants for typography, spacing, and dimensions.
 * These values ensure consistency across Android and iOS.
 */
object ThemeConstants {

    /**
     * Typography scale (text sizes in SP/Points)
     */
    object Typography {
        const val H1 = 32f           // Headlines
        const val H2 = 24f           // Sub-headlines
        const val H3 = 20f           // Titles
        const val H4 = 18f           // Sub-titles
        const val BODY1 = 16f        // Body text
        const val BODY2 = 14f        // Secondary body text
        const val BUTTON = 14f       // Button text
        const val CAPTION = 12f      // Captions
        const val OVERLINE = 10f     // Overline text
    }

    /**
     * Spacing scale (in DP/Points)
     * Following 8dp grid system
     */
    object Spacing {
        const val NONE = 0f
        const val XXS = 2f           // 2dp - minimal spacing
        const val XS = 4f            // 4dp - very small spacing
        const val S = 8f             // 8dp - small spacing
        const val M = 16f            // 16dp - medium spacing (base unit)
        const val L = 24f            // 24dp - large spacing
        const val XL = 32f           // 32dp - extra large spacing
        const val XXL = 48f          // 48dp - very large spacing
        const val XXXL = 64f         // 64dp - maximum spacing
    }

    /**
     * Corner radius values
     */
    object CornerRadius {
        const val NONE = 0f
        const val SMALL = 4f         // Small rounded corners
        const val MEDIUM = 8f        // Medium rounded corners
        const val LARGE = 16f        // Large rounded corners
        const val XLARGE = 24f       // Extra large rounded corners
        const val CIRCLE = 999f      // Fully rounded (pill shape)
    }

    /**
     * Elevation values (for shadows/depth)
     */
    object Elevation {
        const val NONE = 0f
        const val LOW = 2f           // Subtle elevation
        const val MEDIUM = 4f        // Standard elevation
        const val HIGH = 8f          // Prominent elevation
        const val HIGHEST = 16f      // Maximum elevation
    }

    /**
     * Icon sizes
     */
    object IconSize {
        const val SMALL = 16f        // Small icons
        const val MEDIUM = 24f       // Standard icons
        const val LARGE = 32f        // Large icons
        const val XLARGE = 48f       // Extra large icons
    }

    /**
     * Common component sizes
     */
    object ComponentSize {
        const val BUTTON_HEIGHT = 48f           // Standard button height
        const val BUTTON_HEIGHT_SMALL = 36f     // Small button height
        const val INPUT_HEIGHT = 56f            // Text input height
        const val APP_BAR_HEIGHT = 56f          // App bar height
        const val BOTTOM_NAV_HEIGHT = 56f       // Bottom navigation height
        const val FAB_SIZE = 56f                // Floating action button
        const val AVATAR_SMALL = 32f            // Small avatar
        const val AVATAR_MEDIUM = 48f           // Medium avatar
        const val AVATAR_LARGE = 64f            // Large avatar
    }

    /**
     * Animation durations (in milliseconds)
     */
    object Animation {
        const val INSTANT = 100L     // Instant feedback
        const val QUICK = 200L       // Quick transitions
        const val NORMAL = 300L      // Standard animations
        const val SLOW = 500L        // Slower animations
    }

    /**
     * Opacity/Alpha values
     */
    object Opacity {
        const val INVISIBLE = 0f
        const val DISABLED = 0.38f   // Disabled content
        const val MEDIUM = 0.6f      // Medium emphasis
        const val HIGH = 0.87f       // High emphasis
        const val FULL = 1f          // Fully opaque
    }
}
