package com.ellkhamitech.foodswipe.data.repository

import com.ellkhamitech.foodswipe.data.remote.FoodApi
import com.ellkhamitech.foodswipe.data.stub.FoodCategoriesStub
import com.ellkhamitech.foodswipe.data.test_response.validFoodResponse
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.experimental.categories.Categories
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by A.Elkhami on 23,April,2022
 */
@ExperimentalCoroutinesApi
class FoodRepositoryImplTest {

    private lateinit var foodRepositoryImpl: FoodRepositoryImpl
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient
    private lateinit var foodApi: FoodApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()

        okHttpClient = OkHttpClient
            .Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()

        foodApi = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(FoodApi::class.java)

        foodRepositoryImpl = FoodRepositoryImpl(
            foodApi = foodApi
        )
    }

    @Test
    fun `when getFoodCategories called return list categories successfully`() = runTest {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(validFoodResponse)
        )

        val categoriesList = foodRepositoryImpl.getFoodCategories()

        assertThat(categoriesList).isEqualTo(Result.success(FoodCategoriesStub.foodCategories))
    }

    @Test
    fun `when getFoodCategories called return error`() = runTest {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(401)
        )

        val categoriesList = foodRepositoryImpl.getFoodCategories()

        assertThat(categoriesList.isFailure).isEqualTo(Result.failure<List<Categories>>(Exception("error")).isFailure)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}