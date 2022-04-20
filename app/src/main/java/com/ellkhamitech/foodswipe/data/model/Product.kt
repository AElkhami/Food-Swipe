package com.ellkhamitech.foodswipe.data.model

data class Product(
    val categoryId: String,
    val description: String,
    val id: String,
    val name: String,
    val salePrice: SalePrice,
    val url: String
)