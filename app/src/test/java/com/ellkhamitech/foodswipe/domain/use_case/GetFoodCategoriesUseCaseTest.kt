package com.ellkhamitech.foodswipe.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ellkhamitech.foodswipe.data.repository.FoodRepositoryImplFake
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Created by A.Elkhami on 21,April,2022
 */
@ExperimentalCoroutinesApi
class GetFoodCategoriesUseCaseTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var getFoodCategoriesUseCase: GetFoodCategoriesUseCase
    private lateinit var foodRepository: FoodRepositoryImplFake

    @Before
    fun setup() {
        foodRepository = FoodRepositoryImplFake()
        getFoodCategoriesUseCase = GetFoodCategoriesUseCase(foodRepository)
    }

    @Test
    fun `when getFoodCategoriesUseCase called, expect data`() = runTest {
        val foodCategories = getFoodCategoriesUseCase()

        assertThat(foodCategories, Matchers.samePropertyValuesAs(FoodCategoriesStub.foodCategories))
    }

    @Test
    fun `when getFoodCategoriesUseCase called, expect error`() = runTest {
        foodRepository.setReturnError(true)

        val foodCategories = getFoodCategoriesUseCase()

        assertThat(foodCategories, Throwable(message = "error"))
    }
}