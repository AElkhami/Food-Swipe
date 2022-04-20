package com.ellkhamitech.foodswipe.data.repository

import com.ellkhamitech.foodswipe.data.mapper.toFoodCategory
import com.ellkhamitech.foodswipe.data.remote.FoodApi
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.repository.FoodRepository

/**
 * Created by A.Elkhami on 20,April,2022
 */
class FoodRepositoryImpl(
    private val foodApi: FoodApi
) : FoodRepository {
    override suspend fun getFoodRepository(): Result<List<FoodCategory>> {
        return try {
            val foodCategories = foodApi.getFoodCategories()
            Result.success(foodCategories.map { it.toFoodCategory() })
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }
}