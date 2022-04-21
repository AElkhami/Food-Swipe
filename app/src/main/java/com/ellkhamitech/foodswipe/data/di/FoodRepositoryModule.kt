package com.ellkhamitech.foodswipe.data.di

import com.ellkhamitech.foodswipe.data.remote.FoodApi
import com.ellkhamitech.foodswipe.data.repository.FoodRepositoryImpl
import com.ellkhamitech.foodswipe.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by A.Elkhami on 21,April,2022
 */
@Module
@InstallIn(SingletonComponent::class)
object FoodRepositoryModule {

    @Singleton
    @Provides
    fun provideFoodRepository(foodApi: FoodApi): FoodRepository {
        return FoodRepositoryImpl(foodApi)
    }
}