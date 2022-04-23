package com.ellkhamitech.foodswipe.data.stub

import com.ellkhamitech.foodswipe.data.model.SalePrice
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.model.FoodProduct


object FoodCategoriesStub {

    private val salePrice = SalePrice("10", "EGP")

    private val foodProduct1 = FoodProduct(
        name = "Orange",
        salePrice = salePrice,
        url = "/image.jpg"
    )
    private val foodProduct2 = FoodProduct(
        "Apple",
        salePrice,
        ""
    )

    private val productsList = listOf(foodProduct1, foodProduct2)

    private val foodCategory = FoodCategory("name", productsList)

    val foodCategories = listOf(foodCategory)

}