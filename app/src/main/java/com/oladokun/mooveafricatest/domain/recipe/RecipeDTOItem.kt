package com.oladokun.mooveafricatest.domain.recipe

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


/**
 * Data class parcelized with @Parcelize to be able to pass it through bundles
 */
@Parcelize
data class RecipeDTOItem(
    val id: Int,
    val image: String? = null,
    val ingredients: List<Ingredient>? = null,
    val name: String? = null,
    val servings: Int? = 0,
    val steps: List<Step>? = null
) : Parcelable