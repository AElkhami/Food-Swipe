package com.ellkhamitech.foodswipe.domain.use_case

import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.ellkhamitech.foodswipe.domain.repository.FoodRepository

/**
 * Created by A.Elkhami on 21,April,2022
 */
class GetFoodCategoriesUseCase(private val repository: FoodRepository) {

    suspend operator fun invoke(): Result<List<FoodCategory>> {
        return repository.getFoodCategories()
    }
}