package com.ellkhamitech.foodswipe.domain.repository

import com.ellkhamitech.foodswipe.domain.model.FoodCategory

/**
 * Created by A.Elkhami on 20,April,2022
 */
interface FoodRepository {
    suspend fun getFoodCategories(): Result<List<FoodCategory>>
}