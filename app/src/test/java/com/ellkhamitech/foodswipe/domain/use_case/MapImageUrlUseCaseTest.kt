package com.ellkhamitech.foodswipe.domain.use_case

import com.ellkhamitech.foodswipe.data.model.Category
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by A.Elkhami on 21,April,2022
 */
class MapImageUrlUseCaseTest {

    private lateinit var mapImageUrlUseCase: MapImageUrlUseCase

    @Before
    fun setUp() {
        mapImageUrlUseCase = MapImageUrlUseCase()
    }

    @Test
    fun `when mapImageUrlUseCase called return mapped url`() {
        val foodCategoriesWithMappedUrl = mapImageUrlUseCase(FoodCategoriesStub.foodCategories)

        assertThat(foodCategoriesWithMappedUrl[0].products[0].url)
            .isEqualTo("http://mobcategories.s3-website-eu-west-1.amazonaws.com/image.jpg")
    }

    @Test
    fun `when mapImageUrlUseCase called on empty list return empty list`() {
        val foodCategoriesWithMappedUrl = mapImageUrlUseCase(emptyList())

        assertThat(foodCategoriesWithMappedUrl)
            .isEqualTo(emptyList<Category>())
    }

    @Test
    fun `when mapImageUrlUseCase called on empty url return invalid image url`() {
        val foodCategoriesWithMappedUrl = mapImageUrlUseCase(FoodCategoriesStub.foodCategories)

        assertThat(foodCategoriesWithMappedUrl[0].products[1].url)
            .isEqualTo("http://mobcategories.s3-website-eu-west-1.amazonaws.com")
    }

    @Test
    fun `when mapImageUrlUseCase called entered product list size should be same`() {
        val foodCategoriesWithMappedUrl = mapImageUrlUseCase(FoodCategoriesStub.foodCategories)

        assertThat(foodCategoriesWithMappedUrl[0].products.size)
            .isEqualTo(2)
    }
}