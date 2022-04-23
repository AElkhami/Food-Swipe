package com.ellkhamitech.foodswipe.data.remote.fake

import com.ellkhamitech.foodswipe.data.model.Category
import com.ellkhamitech.foodswipe.data.remote.FoodApi
import com.ellkhamitech.foodswipe.data.stub.CategoriesStub

/**
 * Created by A.Elkhami on 23,April,2022
 */
class FoodApiFake : FoodApi {

    private var shouldThrowException = false

    fun setShouldThrowException(value: Boolean) {
        shouldThrowException = value
    }

    @Throws(Exception::class)
    override suspend fun getFoodCategories(): List<Category> {
        if (shouldThrowException) {
            throw Exception("error")
        }
        return CategoriesStub.categories
    }
}