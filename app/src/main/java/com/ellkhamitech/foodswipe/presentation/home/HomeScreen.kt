package com.ellkhamitech.foodswipe.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.annotation.ExperimentalCoilApi
import com.ellkhamitech.foodswipe.R
import com.ellkhamitech.foodswipe.data.model.SalePrice
import com.ellkhamitech.foodswipe.domain.model.FoodProduct
import com.ellkhamitech.foodswipe.presentation.components.FoodItem
import com.ellkhamitech.foodswipe.presentation.components.TextWithCurvedBackground
import com.ellkhamitech.foodswipe.presentation.destinations.ProductDetailScreenDestination
import com.ellkhamitech.foodswipe.presentation.ui.Dimensions
import com.ellkhamitech.foodswipe.presentation.ui.LocalSpacing
import com.ellkhamitech.foodswipe.presentation.ui.theme.OffWhiteBackground
import com.ellkhamitech.foodswipe.presentation.ui.theme.OrangeYellow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/**
 * Created by A.Elkhami on 22,April,2022
 */
@ExperimentalCoilApi
@Destination(start = true)
@Composable
fun HomeScreen(
    userName: String = "John 117",
    navigator: DestinationsNavigator
) {
    val spacing = LocalSpacing.current

    val categoryList = listOf("Food", "Drink")

    Column(modifier = Modifier.background(OffWhiteBackground)) {
        WelcomeSection(userName = userName, spacing = spacing)

        Divider(
            color = OrangeYellow,
            thickness = spacing.dividerThickness,
            modifier = Modifier.padding(
                top = spacing.spaceMedium,
                bottom = spacing.spaceMedium,
                start = spacing.spaceLarge,
                end = spacing.spaceLarge
            )
        )

        CategoriesSection(spacing = spacing, categoryList)

        ProductsSection(
            listOf(
                FoodProduct(
                    "Apple",
                    SalePrice("10", "$"),
                    "http://mobcategories.s3-website-eu-west-1.amazonaws.com/Bread.jpg"
                ),
                FoodProduct(
                    "Orange",
                    SalePrice("20", "$"),
                    "http://mobcategories.s3-website-eu-west-1.amazonaws.com/Bread.jpg"
                ),
                FoodProduct(
                    "Milk",
                    SalePrice("30", "$"),
                    "http://mobcategories.s3-website-eu-west-1.amazonaws.com/Bread.jpg"
                ),
                FoodProduct(
                    "Other",
                    SalePrice("30", "$"),
                    "http://mobcategories.s3-website-eu-west-1.amazonaws.com/Bread.jpg"
                )
            ),
            navigator
        )
    }
}

@Composable
fun WelcomeSection(
    userName: String,
    spacing: Dimensions
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = spacing.spaceExtraLarge,
                start = spacing.spaceLarge,
                end = spacing.spaceLarge,
                bottom = spacing.spaceLarge
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = stringResource(id = R.string.hi, userName),
                style = MaterialTheme.typography.h5,
                color = Color.Black
            )
            Text(
                text = stringResource(id = R.string.welcome_back),
                style = MaterialTheme.typography.h5,
                color = Color.Gray
            )
        }
        Image(
            painter = painterResource(id = R.drawable.master_chief),
            contentDescription = stringResource(id = R.string.user_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(spacing.userImageSize)
                .clip(CircleShape)
                .aspectRatio(1f)
        )
    }
}

@Composable
fun CategoriesSection(
    spacing: Dimensions,
    categoryNames: List<String>
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = spacing.spaceLarge,
                end = spacing.spaceLarge
            )
    ) {
        Text(
            text = stringResource(id = R.string.categories),
            style = MaterialTheme.typography.h6,
            color = Color.Black
        )
        LazyRow {
            items(categoryNames.size) {
                TextWithCurvedBackground(
                    name = categoryNames[it],
                    isSelectedBoolean = selectedIndex == it,
                    onClick = { selectedIndex = it }
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ProductsSection(
    products: List<FoodProduct>,
    navigator: DestinationsNavigator
) {
    LazyColumn {
        items(products.size) {
            FoodItem(
                foodName = products[it].name,
                salePrice = products[it].salePrice,
                url = products[it].url,
                onClick = {
                    navigator.navigate(
                        ProductDetailScreenDestination(
                            products[it]
                        )
                    )
                }
            )
        }
    }
}