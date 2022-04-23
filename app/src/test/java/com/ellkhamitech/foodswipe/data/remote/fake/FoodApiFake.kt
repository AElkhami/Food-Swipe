package com.ellkhamitech.foodswipe.data.remote.fake

import com.ellkhamitech.foodswipe.data.model.Category
import com.ellkhamitech.foodswipe.data.remote.FoodApi
import com.ellkhamitech.foodswipe.data.stub.CategoriesStub

/**
 * Created by A.Elkhami on 23,April,2022
 */
class FoodApiFake: FoodApi {

    override suspend fun getFoodCategories(): List<Category> {
        return CategoriesStub.categories
    }
}