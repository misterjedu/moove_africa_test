package com.oladokun.mooveafricatest.domain.recipe

data class RecipeDTOItem(
    val id: Int,
    val image: String? = null,
    val ingredients: List<Ingredient>? = null,
    val name: String? = null,
    val servings: Int? = 0,
    val steps: List<Step>? = null
)