package com.ellkhamitech.foodswipe.domain.model

/**
 * Created by A.Elkhami on 20,April,2022
 */
data class FoodCategory(
    val name: String,
    val products: List<FoodProduct>
)
