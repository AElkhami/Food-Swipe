package com.ellkhamitech.foodswipe.data.repository

import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.repository.FoodRepository

/**
 * Created by A.Elkhami on 21,April,2022
 */
class FoodRepositoryImplFake : FoodRepository {

    private var shouldReturnError = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override suspend fun getFoodCategories(): Result<List<FoodCategory>> {
        return if (shouldReturnError) {
            Result.success(FoodCategoriesStub.foodCategories)
        } else {
            Result.failure(Throwable(message = "error"))
        }
    }
}