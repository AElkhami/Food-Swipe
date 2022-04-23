package com.ellkhamitech.foodswipe.presentation.util

import android.content.Context

/**
 * Created by A.Elkhami on 23,April,2022
 */
sealed class UiText {
    data class DynamicString(val message: String) : UiText()
    data class StringResource(val resId: Int) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> message
            is StringResource -> context.getString(resId)
        }
    }
}