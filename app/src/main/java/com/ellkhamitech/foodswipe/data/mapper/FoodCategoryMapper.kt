package com.ellkhamitech.foodswipe.data.mapper

import com.ellkhamitech.foodswipe.data.model.Category
import com.ellkhamitech.foodswipe.domain.model.FoodCategory

/**
 * Created by A.Elkhami on 20,April,2022
 */
fun Category.toFoodCategory(): FoodCategory{
    return FoodCategory(
        name = name,
        products = products
    )
}