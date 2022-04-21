package com.ellkhamitech.foodswipe.domain.di

import com.ellkhamitech.foodswipe.domain.repository.FoodRepository
import com.ellkhamitech.foodswipe.domain.use_case.FoodUseCases
import com.ellkhamitech.foodswipe.domain.use_case.GetFoodCategoriesUseCase
import com.ellkhamitech.foodswipe.domain.use_case.MapImageUrlUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * Created by A.Elkhami on 21,April,2022
 */
@Module
@InstallIn(ViewModelComponent::class)
object FoodDomainModule {

    @ViewModelScoped
    @Provides
    fun provideFoodDomainModule(
        repository: FoodRepository
    ): FoodUseCases {
        return FoodUseCases(
            getFoodCategoriesUseCase = GetFoodCategoriesUseCase(repository = repository),
            mapImageUrlUseCase = MapImageUrlUseCase()
        )
    }
}