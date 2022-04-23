package com.ellkhamitech.foodswipe.data.stub

import com.ellkhamitech.foodswipe.data.model.Category
import com.ellkhamitech.foodswipe.data.model.Product
import com.ellkhamitech.foodswipe.data.model.SalePrice


object CategoriesStub {

    private val salePrice = SalePrice("10", "EGP")

    private val product1 = Product(
        categoryId = "2",
        description = "desc",
        id = "1",
        name = "Orange",
        salePrice = salePrice,
        url = "/image.jpg"
    )
    private val product2 = Product(
        "1",
        "dec",
        "2",
        "Apple",
        salePrice,
        ""
    )

    private val productsList = listOf(product1, product2)

    private val foodCategory = Category(
        id = "1",
        name = "name",
        products = productsList,
        description = "test"
    )

    val categories = listOf(foodCategory)

}