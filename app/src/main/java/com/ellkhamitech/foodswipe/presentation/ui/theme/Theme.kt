package com.ellkhamitech.foodswipe.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.ellkhamitech.foodswipe.presentation.ui.Dimensions
import com.ellkhamitech.foodswipe.presentation.ui.LocalSpacing
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun FoodSwipeTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setSystemBarsColor(
        color = OffWhiteBackground
    )

    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}