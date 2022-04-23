package com.ellkhamitech.foodswipe.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ellkhamitech.foodswipe.data.repository.fake.FoodRepositoryImplFake
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesAfterMappingStub
import com.ellkhamitech.foodswipe.domain.use_case.FoodUseCases
import com.ellkhamitech.foodswipe.domain.use_case.GetFoodCategoriesUseCase
import com.ellkhamitech.foodswipe.domain.use_case.MapImageUrlUseCase
import com.ellkhamitech.foodswipe.presentation.util.UiEvent
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Created by A.Elkhami on 23,April,2022
 */
@DelicateCoroutinesApi
@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var repository: FoodRepositoryImplFake

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {

        Dispatchers.setMain(mainThreadSurrogate)

        repository = FoodRepositoryImplFake()

        val foodUseCases = FoodUseCases(
            getFoodCategoriesUseCase = GetFoodCategoriesUseCase(repository = repository),
            mapImageUrlUseCase = MapImageUrlUseCase()
        )
        homeViewModel = HomeViewModel(foodUseCases)
    }

    @Test
    fun `when onEvent OnCategoryClick get selected product`() = runTest {
        val selectedIndex = 0

        homeViewModel.onEvent(HomeEvent.OnCategoryClick(selectedIndex))

        assertThat(homeViewModel.state.foodProducts)
            .isEqualTo(FoodCategoriesAfterMappingStub.foodCategories[selectedIndex].products)
    }

    @Test
    fun `when onEvent OnGetFoodCategories success get food categories`() = runTest {
        homeViewModel.onEvent(HomeEvent.OnGetFoodCategories)

        assertThat(homeViewModel.state.foodCategories)
            .isEqualTo(FoodCategoriesAfterMappingStub.foodCategories)
    }

    @Test
    fun `when onEvent OnGetFoodCategories fails get error message`() = runBlocking {
        repository.setReturnError(true)

        homeViewModel.onEvent(HomeEvent.OnGetFoodCategories)

        assertThat(homeViewModel.uiEvent.first()).isInstanceOf(UiEvent.ShowSnackBar::class.java)
    }

    @Test
    fun `when generateCategoryNamesList return list of categories`() {
        val categoryNames =
            homeViewModel.generateCategoryNamesList(FoodCategoriesAfterMappingStub.foodCategories)

        assertThat(categoryNames)
            .isEqualTo(FoodCategoriesAfterMappingStub.categoriesName)
    }
}