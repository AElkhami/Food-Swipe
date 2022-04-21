package com.ellkhamitech.foodswipe.domain.use_case

import com.ellkhamitech.foodswipe.data.remote.FoodApi.Companion.BASE_URL
import com.ellkhamitech.foodswipe.domain.model.FoodCategory

/**
 * Created by A.Elkhami on 21,April,2022
 */
class MapImageUrlUseCase {

    operator fun invoke(foodCategories: List<FoodCategory>): List<FoodCategory> {
        return foodCategories.map { foodCategory ->
            foodCategory.copy(products = foodCategory.products.map { product ->
                product.copy(
                    url = BASE_URL
                        .replaceAfter("com", product.url, "//")
                )
            }
            )
        }
    }
}