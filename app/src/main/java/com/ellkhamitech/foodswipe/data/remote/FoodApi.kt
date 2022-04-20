package com.ellkhamitech.foodswipe.data.remote

import com.ellkhamitech.foodswipe.data.model.Categories
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by A.Elkhami on 20,April,2022
 */
interface FoodApi {
    @GET(".")
    suspend fun getFoodCategories(): Response<Categories>

    //Base URL should be added to local.properties file but its here as its demo.
    companion object {
        const val BASE_URL = "http://mobcategories.s3-website-eu-west-1.amazonaws.com/"
    }
}