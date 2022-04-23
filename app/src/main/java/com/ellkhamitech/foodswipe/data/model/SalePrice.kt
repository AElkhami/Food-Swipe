package com.ellkhamitech.foodswipe.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SalePrice(
    val amount: String,
    val currency: String
): Parcelable