package com.ellkhamitech.foodswipe.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ellkhamitech.foodswipe.R
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.use_case.FoodUseCases
import com.ellkhamitech.foodswipe.presentation.util.Constants.DefaultCategoryIndex
import com.ellkhamitech.foodswipe.presentation.util.UiEvent
import com.ellkhamitech.foodswipe.presentation.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by A.Elkhami on 23,April,2022
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val foodUseCases: FoodUseCases
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    var uiEvent = _uiEvent.receiveAsFlow()

    init {
        onEvent(HomeEvent.OnGetFoodCategories)
        state = state.copy(isLoading = true)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.OnCategoryClick -> {
                if (state.foodCategories.isNotEmpty()) {
                    state = state.copy(
                        foodProducts = state.foodCategories[event.selectedIndex].products
                    )
                }
            }
            HomeEvent.OnGetFoodCategories -> {
                viewModelScope.launch {
                    foodUseCases.getFoodCategoriesUseCase()
                        .onSuccess { categoriesList ->
                            state = state.copy(
                                foodCategories = foodUseCases.mapImageUrlUseCase(categoriesList),
                                categoryNames = generateCategoryNamesList(categoriesList),
                                foodProducts = foodUseCases
                                    .mapImageUrlUseCase(categoriesList)[DefaultCategoryIndex]
                                    .products,
                                isLoading = false
                            )
                        }
                        .onFailure {
                            _uiEvent.send(
                                UiEvent.ShowSnackBar(
                                    UiText.StringResource(R.string.response_error)
                                )
                            )
                            state = state.copy(isLoading = false)
                        }
                }
            }
        }
    }

    fun generateCategoryNamesList(foodCategories: List<FoodCategory>): List<String> {
        val categoryNamesList = mutableListOf<String>()
        foodCategories.forEach { category ->
            categoryNamesList.add(category.name)
        }
        return categoryNamesList
    }
}