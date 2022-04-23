package com.ellkhamitech.foodswipe.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ellkhamitech.foodswipe.data.remote.fake.FoodApiFake
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.experimental.categories.Categories
import org.junit.rules.TestRule

/**
 * Created by A.Elkhami on 23,April,2022
 */
@ExperimentalCoroutinesApi
class FoodRepositoryImplTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var foodRepositoryImpl: FoodRepositoryImpl
    private lateinit var foodApi: FoodApiFake

    @Before
    fun setUp() {
        foodApi = FoodApiFake()
        foodRepositoryImpl = FoodRepositoryImpl(foodApi)
    }

    @Test
    fun `when getFoodCategories called return list categories successfully`() = runTest {
        val categoriesList = foodRepositoryImpl.getFoodCategories()

        assertThat(categoriesList).isEqualTo(Result.success(FoodCategoriesStub.foodCategories))
    }

    @Test
    fun `when getFoodCategories called return error`() = runTest {

        foodApi.setShouldThrowException(true)

        val categoriesList = foodRepositoryImpl.getFoodCategories()

        assertThat(categoriesList.isFailure).isEqualTo(Result.failure<List<Categories>>(Exception("error")).isFailure)
    }
}