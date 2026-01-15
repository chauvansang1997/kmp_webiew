package com.kmp.example.core.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

/**
 * Extension functions for Android Context.
 */

/**
 * Shows a short toast message.
 */
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

/**
 * Shows a short toast message from string resource.
 */
fun Context.showToast(@StringRes messageRes: Int) {
    Toast.makeText(this, messageRes, Toast.LENGTH_LONG).show()
}
