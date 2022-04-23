package com.ellkhamitech.foodswipe.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.ellkhamitech.foodswipe.R
import com.ellkhamitech.foodswipe.domain.model.FoodProduct
import com.ellkhamitech.foodswipe.presentation.components.FoodItem
import com.ellkhamitech.foodswipe.presentation.components.TextWithCurvedBackground
import com.ellkhamitech.foodswipe.presentation.destinations.ProductDetailScreenDestination
import com.ellkhamitech.foodswipe.presentation.ui.Dimensions
import com.ellkhamitech.foodswipe.presentation.ui.LocalSpacing
import com.ellkhamitech.foodswipe.presentation.ui.theme.OffWhiteBackground
import com.ellkhamitech.foodswipe.presentation.ui.theme.OrangeYellow
import com.ellkhamitech.foodswipe.presentation.util.UiEvent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Created by A.Elkhami on 22,April,2022
 */
@ExperimentalCoilApi
@Destination(start = true)
@Composable
fun HomeScreen(
    userName: String = "John 117",
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val scaffoldState = rememberScaffoldState()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(
                            context
                        )
                    )
                }
            }
        }
    }

    Column(modifier = Modifier.background(OffWhiteBackground)) {
        WelcomeSection(
            userName = userName,
            spacing = spacing
        )
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
        CategoriesSection(
            spacing = spacing,
            viewModel.state.categoryNames,
            viewModel,
            coroutineScope,
            listState
        )
        ProductsSection(
            viewModel.state.foodProducts,
            navigator,
            listState
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
    categoryNames: List<String>,
    viewModel: HomeViewModel,
    coroutineScope: CoroutineScope,
    listState: LazyListState
) {
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    viewModel.onEvent(HomeEvent.OnCategoryClick(selectedIndex))

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
                    onClick = {
                        selectedIndex = it
                        viewModel.onEvent(HomeEvent.OnCategoryClick(selectedIndex))
                        coroutineScope.launch {
                            listState.animateScrollToItem(index = 0)
                        }
                    }
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun ProductsSection(
    products: List<FoodProduct>,
    navigator: DestinationsNavigator,
    listState: LazyListState
) {
    LazyColumn(state = listState) {
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