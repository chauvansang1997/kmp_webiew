package com.kmp.example.core.theme

import android.content.Context
import android.content.res.Configuration
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat
import com.kmp.example.R

/**
 * Helper class for accessing theme resources programmatically.
 */
object ThemeHelper {

    /**
     * Check if the device is in dark mode.
     */
    fun isDarkMode(context: Context): Boolean {
        return context.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
    }

    /**
     * Get color based on current theme.
     */
    fun getColor(context: Context, @ColorRes colorRes: Int): Int {
        return ContextCompat.getColor(context, colorRes)
    }

    /**
     * Get dimension based on current theme.
     */
    fun getDimen(context: Context, @DimenRes dimenRes: Int): Float {
        return context.resources.getDimension(dimenRes)
    }

    /**
     * Get dimension in pixels.
     */
    fun getDimenPx(context: Context, @DimenRes dimenRes: Int): Int {
        return context.resources.getDimensionPixelSize(dimenRes)
    }
}

/**
 * Extension function to check if dark mode is enabled.
 */
val Context.isDarkMode: Boolean
    get() = ThemeHelper.isDarkMode(this)

/**
 * Extension function to get color from resources.
 */
fun Context.getThemeColor(@ColorRes colorRes: Int): Int {
    return ThemeHelper.getColor(this, colorRes)
}
