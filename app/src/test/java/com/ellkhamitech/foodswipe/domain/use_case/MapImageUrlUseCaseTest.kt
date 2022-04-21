package com.ellkhamitech.foodswipe.domain.use_case

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesAfterMappingStub
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Created by A.Elkhami on 21,April,2022
 */
class MapImageUrlUseCaseTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var mapImageUrlUseCase: MapImageUrlUseCase

    @Before
    fun setUp() {
        mapImageUrlUseCase = MapImageUrlUseCase()
    }

    @Test
    fun `when mapImageUrlUseCase called return mapped url`() {
        val foodCategoriesWithMappedUrl = mapImageUrlUseCase(FoodCategoriesStub.foodCategories)

        assertThat(foodCategoriesWithMappedUrl)
            .isEqualTo(FoodCategoriesAfterMappingStub.foodCategories)
    }
}