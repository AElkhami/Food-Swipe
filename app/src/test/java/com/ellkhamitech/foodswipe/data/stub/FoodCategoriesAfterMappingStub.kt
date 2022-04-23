package com.ellkhamitech.foodswipe.data.stub

import com.ellkhamitech.foodswipe.data.model.Product
import com.ellkhamitech.foodswipe.data.model.SalePrice
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.model.FoodProduct


object FoodCategoriesAfterMappingStub {

    private val salePrice = SalePrice("10", "EGP")

    private val product1 = FoodProduct(
        name = "Orange",
        salePrice = salePrice,
        url = "http://mobcategories.s3-website-eu-west-1.amazonaws.com/image.jpg"
    )
    private val product2 = FoodProduct(
        "Apple",
        salePrice,
        "http://mobcategories.s3-website-eu-west-1.amazonaws.com"
    )

    private val productsList = listOf(product1, product2)

    private val foodCategory = FoodCategory("name", productsList)

    val foodCategories = listOf(foodCategory)

    val categoriesName = listOf("name")

}