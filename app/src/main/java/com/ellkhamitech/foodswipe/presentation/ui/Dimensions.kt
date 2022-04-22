package com.ellkhamitech.foodswipe.presentation.ui

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by A.Elkhami on 22,April,2022
 */
data class Dimensions(
    val default: Dp = 0.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,
    val userImageSize: Dp = 70.dp,
    val imageBorderWidth: Dp = 0.8.dp,
    val foodImageSize: Dp = 100.dp,
    val foodItemCornerSize: Dp = 28.dp,
    val curvedCornerSize: Dp = 50.dp,
    val dividerThickness: Dp = 1.dp
)

val LocalSpacing = compositionLocalOf { Dimensions() }