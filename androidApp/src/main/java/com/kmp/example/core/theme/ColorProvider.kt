package com.kmp.example.core.theme

import com.kmp.example.shared.core.theme.ColorPalette

/**
 * Provides access to the shared color palette from Android.
 * Converts hex strings to Android Color integers.
 */
object ColorProvider {

    /**
     * Primary colors
     */
    object Primary {
        val default: Long = ColorPalette.Primary.DEFAULT.hexToColorInt()
        val variant: Long = ColorPalette.Primary.VARIANT.hexToColorInt()
        val light: Long = ColorPalette.Primary.LIGHT.hexToColorInt()
    }

    /**
     * Secondary colors
     */
    object Secondary {
        val default: Long = ColorPalette.Secondary.DEFAULT.hexToColorInt()
        val variant: Long = ColorPalette.Secondary.VARIANT.hexToColorInt()
        val light: Long = ColorPalette.Secondary.LIGHT.hexToColorInt()
    }

    /**
     * Background colors
     */
    object Background {
        val light: Long = ColorPalette.Background.LIGHT.hexToColorInt()
        val dark: Long = ColorPalette.Background.DARK.hexToColorInt()
        val surfaceLight: Long = ColorPalette.Background.SURFACE_LIGHT.hexToColorInt()
        val surfaceDark: Long = ColorPalette.Background.SURFACE_DARK.hexToColorInt()
    }

    /**
     * Text colors
     */
    object Text {
        val primaryLight: Long = ColorPalette.Text.PRIMARY_LIGHT.hexToColorInt()
        val primaryDark: Long = ColorPalette.Text.PRIMARY_DARK.hexToColorInt()
        val secondaryLight: Long = ColorPalette.Text.SECONDARY_LIGHT.hexToColorInt()
        val secondaryDark: Long = ColorPalette.Text.SECONDARY_DARK.hexToColorInt()
    }

    /**
     * Status colors
     */
    object Status {
        val error: Long = ColorPalette.Status.ERROR.hexToColorInt()
        val errorDark: Long = ColorPalette.Status.ERROR_DARK.hexToColorInt()
        val success: Long = ColorPalette.Status.SUCCESS.hexToColorInt()
        val warning: Long = ColorPalette.Status.WARNING.hexToColorInt()
        val info: Long = ColorPalette.Status.INFO.hexToColorInt()
    }

    /**
     * Converts hex string to color integer.
     */
    private fun String.hexToColorInt(): Long {
        var colorString = this
        if (colorString.startsWith("#")) {
            colorString = colorString.substring(1)
        }

        // Add alpha if not present
        if (colorString.length == 6) {
            colorString = "FF$colorString"
        }

        return colorString.toLong(16)
    }
}
