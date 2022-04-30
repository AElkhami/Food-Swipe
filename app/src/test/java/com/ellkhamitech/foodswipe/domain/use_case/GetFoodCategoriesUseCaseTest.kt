package com.ellkhamitech.foodswipe.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ellkhamitech.foodswipe.data.repository.FoodRepositoryImpl
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.ellkhamitech.foodswipe.domain.model.FoodCategory
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

/**
 * Created by A.Elkhami on 21,April,2022
 */
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetFoodCategoriesUseCaseTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var getFoodCategoriesUseCase: GetFoodCategoriesUseCase

    @Mock
    private lateinit var foodRepository: FoodRepositoryImpl

    @Before
    fun setup() {
        getFoodCategoriesUseCase = GetFoodCategoriesUseCase(foodRepository)
    }

    @Test
    fun `when getFoodCategoriesUseCase called, expect data`() = runTest {
        val success = Result.success(FoodCategoriesStub.foodCategories)
        `when`(foodRepository.getFoodCategories()).thenReturn(success)

        val foodCategories = getFoodCategoriesUseCase()

        assertThat(foodCategories).isEqualTo(success)
    }

    @Test
    fun `when getFoodCategoriesUseCase called, expect error`() = runTest {
        val failure = Result.failure<List<FoodCategory>>(Throwable(message = "error"))

        `when`(foodRepository.getFoodCategories()).thenReturn(failure)

        val foodCategories = getFoodCategoriesUseCase()

        assertThat(foodCategories).isEqualTo(failure)
    }
}