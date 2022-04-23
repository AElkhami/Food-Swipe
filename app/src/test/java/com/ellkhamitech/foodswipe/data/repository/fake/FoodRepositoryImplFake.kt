package com.ellkhamitech.foodswipe.data.repository.fake

import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.repository.FoodRepository

/**
 * Created by A.Elkhami on 21,April,2022
 */
class FoodRepositoryImplFake : FoodRepository {

    private var shouldReturnError = false

    val failureCase = Result.failure<List<FoodCategory>>(Throwable(message = "error"))
    val successCase = Result.success(FoodCategoriesStub.foodCategories)

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override suspend fun getFoodCategories(): Result<List<FoodCategory>> {
        return if (shouldReturnError) {
            failureCase
        } else {
            successCase
        }
    }
}