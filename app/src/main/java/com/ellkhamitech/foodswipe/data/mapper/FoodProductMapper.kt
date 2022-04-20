package com.ellkhamitech.foodswipe.data.mapper

import com.ellkhamitech.foodswipe.data.model.Product
import com.ellkhamitech.foodswipe.domain.model.FoodProduct

/**
 * Created by A.Elkhami on 20,April,2022
 */
fun Product.toFoodProduct(): FoodProduct {
    return FoodProduct(
        name = name,
        salePrice = salePrice,
        url = url
    )
}