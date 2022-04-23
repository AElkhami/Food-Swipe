package com.ellkhamitech.foodswipe.presentation.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ellkhamitech.foodswipe.domain.use_case.FoodUseCases
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock

/**
 * Created by A.Elkhami on 23,April,2022
 */
class HomeViewModelTest {

    @get:Rule
    val testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var homeViewModel: HomeViewModel

    @Mock
    private lateinit var foodUseCases: FoodUseCases

    @Before
    fun setUp() {
        homeViewModel = HomeViewModel(foodUseCases)
    }

    @Test
    fun `when onEvent OnCategoryClick get selected product`(){

    }

    @Test
    fun `when onEvent OnGetFoodCategories success get food categories`(){

    }

    @Test
    fun `when onEvent OnGetFoodCategories fails get error message`(){

    }

    @Test
    fun `when generateCategoryNamesList return list of categories`() {

    }
}