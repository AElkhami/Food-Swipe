package com.ellkhamitech.foodswipe.domain.use_case

import com.ellkhamitech.foodswipe.data.repository.FoodRepositoryImpl
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.google.common.truth.Truth.assertThat
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

/**
 * Created by A.Elkhami on 21,April,2022
 */
@ExperimentalCoroutinesApi
class GetFoodCategoriesUseCaseTest {

    private lateinit var getFoodCategoriesUseCase: GetFoodCategoriesUseCase
    private lateinit var foodRepository: FoodRepositoryImpl

    @Before
    fun setup() {
        foodRepository = mockk()
        getFoodCategoriesUseCase = GetFoodCategoriesUseCase(foodRepository)
    }

    @Test
    fun `when getFoodCategoriesUseCase called, expect data`() = runTest {
        val success = Result.success(FoodCategoriesStub.foodCategories)

        coEvery { foodRepository.getFoodCategories() } returns success

        val foodCategories = getFoodCategoriesUseCase()

        assertThat(foodCategories).isEqualTo(success)
    }

    @Test
    fun `when getFoodCategoriesUseCase called, expect error`() = runTest {
        val failure = Result.failure<List<FoodCategory>>(Throwable(message = "error"))

        coEvery { foodRepository.getFoodCategories() } returns failure

        val foodCategories = getFoodCategoriesUseCase()

        assertThat(foodCategories).isEqualTo(failure)
    }
}