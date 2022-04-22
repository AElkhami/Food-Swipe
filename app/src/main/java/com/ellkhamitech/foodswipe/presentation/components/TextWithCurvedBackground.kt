package com.ellkhamitech.foodswipe.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.ellkhamitech.foodswipe.presentation.ui.LocalSpacing
import com.ellkhamitech.foodswipe.presentation.ui.theme.*

/**
 * Created by A.Elkhami on 22,April,2022
 */
@Composable
fun TextWithCurvedBackground(
    name: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    textStyle: TextStyle = MaterialTheme.typography.body1,
    isSelectedBoolean: Boolean,
    onClick: () -> Unit
) {
    val spacing = LocalSpacing.current

    Box(
        modifier = modifier
            .padding(
                top = spacing.spaceMedium,
                bottom = spacing.spaceMedium
            )
            .clip(RoundedCornerShape(spacing.curvedCornerSize))
            .background(if (isSelectedBoolean) OrangeYellowDark else OrangeYellowLight)
            .clickable { onClick() }
            .padding(spacing.spaceMedium)
    ) {
        Text(
            text = name,
            style = textStyle,
            color = textColor,
            modifier = Modifier.padding(start = spacing.spaceMedium, end = spacing.spaceMedium)
        )
    }
    Spacer(modifier = Modifier.width(spacing.spaceMedium))
}