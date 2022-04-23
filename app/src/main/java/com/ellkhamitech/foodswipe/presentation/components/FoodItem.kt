package com.ellkhamitech.foodswipe.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.ellkhamitech.foodswipe.R
import com.ellkhamitech.foodswipe.data.model.SalePrice
import com.ellkhamitech.foodswipe.presentation.ui.LocalSpacing
import com.ellkhamitech.foodswipe.presentation.ui.theme.FoodItemBackGround
import com.ellkhamitech.foodswipe.presentation.ui.theme.OrangeYellow

/**
 * Created by A.Elkhami on 22,April,2022
 */
@ExperimentalCoilApi
@Composable
fun FoodItem(
    foodName: String,
    salePrice: SalePrice,
    url: String,
    onClick: () -> Unit
) {
    val spacing = LocalSpacing.current

    Box(
        modifier = Modifier
            .padding(
                top = spacing.spaceMedium,
                start = spacing.spaceLarge,
                end = spacing.spaceLarge
            )
            .clip(RoundedCornerShape(spacing.foodItemCornerSize))
            .fillMaxWidth()
            .background(FoodItemBackGround)
            .clickable { onClick() }
            .padding(spacing.spaceMedium)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = rememberImagePainter(
                    data = url,
                    builder = { error(R.drawable.food_placeholder) }
                ),
                contentDescription = stringResource(id = R.string.food_image),
                modifier = Modifier
                    .size(spacing.foodImageSize)
                    .clip(CircleShape)
                    .border(
                        width = spacing.imageBorderWidth,
                        color = OrangeYellow,
                        shape = CircleShape
                    )
                    .background(Color.White)
            )
            Column(modifier = Modifier.padding(spacing.spaceMedium)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = foodName,
                        style = MaterialTheme.typography.h6,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = stringResource(id = R.string.arrow_right)
                    )
                }
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                Text(
                    text = "${salePrice.amount} ${salePrice.currency}",
                    style = MaterialTheme.typography.body2,
                    color = Color.Gray
                )
            }
        }
    }
}