package com.oladokun.mooveafricatest.domain.recipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ingredient(
    val ingredient: String? = null,
    val measure: String? = null,
    val quantity: Float? = 0F
) : Parcelable