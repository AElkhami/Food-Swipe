package com.ellkhamitech.foodswipe.presentation.product_detail

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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.ellkhamitech.foodswipe.R
import com.ellkhamitech.foodswipe.domain.model.FoodProduct
import com.ellkhamitech.foodswipe.presentation.ui.LocalSpacing
import com.ellkhamitech.foodswipe.presentation.ui.theme.FoodItemBackGround
import com.ellkhamitech.foodswipe.presentation.ui.theme.OrangeYellow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Created by A.Elkhami on 22,April,2022
 */
@ExperimentalCoilApi
@Destination
@Composable
fun ProductDetailScreen(
    product: FoodProduct,
    navigator: DestinationsNavigator
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .background(OrangeYellow)
            .fillMaxSize()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back_arrow),
            contentDescription = stringResource(id = R.string.back_arrow),
            modifier = Modifier
                .padding(start = spacing.spaceLarge, top = spacing.spaceLarge)
                .clip(CircleShape)
                .clickable {
                    navigator.navigateUp()
                }
                .background(FoodItemBackGround)
                .padding(spacing.spaceMedium)
        )
        Spacer(modifier = Modifier.height(spacing.spaceDoubleExtraLarge))
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = spacing.curvedCornerSize,
                            topEnd = spacing.curvedCornerSize
                        )
                    )
                    .background(FoodItemBackGround)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
                Text(
                    text = product.name,
                    style = MaterialTheme.typography.h3,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(spacing.spaceMedium))
                Text(
                    text = "${product.salePrice.amount} ${product.salePrice.currency}",
                    style = MaterialTheme.typography.h6,
                    color = Color.Gray
                )
            }

            Image(
                rememberImagePainter(
                    data = product.url,
                    builder = { error(R.drawable.food_placeholder) }
                ),
                contentDescription = stringResource(id = R.string.food_image),
                modifier = Modifier
                    .size(spacing.foodImageSizeLarge)
                    .align(Alignment.TopCenter)
                    .offset(x = spacing.default, y = -spacing.foodImageYOffset)
                    .clip(CircleShape)
                    .border(
                        width = spacing.imageBorderWidthMedium,
                        color = OrangeYellow,
                        shape = CircleShape
                    )
                    .background(Color.White)
            )
        }
    }
}