package com.ellkhamitech.foodswipe.domain.model

import com.ellkhamitech.foodswipe.data.model.Product

/**
 * Created by A.Elkhami on 20,April,2022
 */
data class FoodCategory(
    val name: String,
    val products: List<Product>
)
