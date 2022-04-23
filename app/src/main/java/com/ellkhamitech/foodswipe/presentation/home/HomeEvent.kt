package com.ellkhamitech.foodswipe.presentation.home

/**
 * Created by A.Elkhami on 23,April,2022
 */
sealed class HomeEvent {
    object OnGetFoodCategories : HomeEvent()
    data class OnCategoryClick(val selectedIndex: Int) : HomeEvent()
}
