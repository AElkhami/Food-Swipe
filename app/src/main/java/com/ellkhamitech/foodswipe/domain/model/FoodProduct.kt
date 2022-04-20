package com.ellkhamitech.foodswipe.domain.model

import com.ellkhamitech.foodswipe.data.model.SalePrice

/**
 * Created by A.Elkhami on 20,April,2022
 */
data class FoodProduct(
    val name: String,
    val salePrice: SalePrice,
    val url: String
)
