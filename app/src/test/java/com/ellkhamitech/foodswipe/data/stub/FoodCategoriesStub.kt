package com.ellkhamitech.foodswipe.data.stub

import com.ellkhamitech.foodswipe.data.model.Product
import com.ellkhamitech.foodswipe.data.model.SalePrice
import com.ellkhamitech.foodswipe.domain.model.FoodCategory


object FoodCategoriesStub {

    val salePrice = SalePrice("10", "EGP")

    val product1 = Product(
        categoryId = "2",
        description = "desc",
        id = "1",
        name = "Orange",
        salePrice = salePrice,
        url = "/image.jpg"
    )
    val product2 = Product(
        "1",
        "dec",
        "2",
        "Apple",
        salePrice,
        "/image2.jpg"
    )

    val productsList = listOf(product1, product2)

    val foodCategory = FoodCategory("name", productsList)

    val foodCategories = listOf(foodCategory)

}