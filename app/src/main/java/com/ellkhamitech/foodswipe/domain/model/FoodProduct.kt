package com.ellkhamitech.foodswipe.domain.model

import android.os.Parcelable
import com.ellkhamitech.foodswipe.data.model.SalePrice
import kotlinx.parcelize.Parcelize

/**
 * Created by A.Elkhami on 20,April,2022
 */
@Parcelize
data class FoodProduct(
    val name: String,
    val salePrice: SalePrice,
    val url: String
): Parcelable
