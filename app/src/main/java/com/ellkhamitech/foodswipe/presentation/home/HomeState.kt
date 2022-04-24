package com.ellkhamitech.foodswipe.presentation.home

import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.model.FoodProduct

/**
 * Created by A.Elkhami on 23,April,2022
 */
data class HomeState(
    val categoryNames : List<String>  = emptyList(),
    val foodCategories: List<FoodCategory> = emptyList(),
    val foodProducts: List<FoodProduct> = emptyList(),
    var selectedIndex: Int = 0
)
