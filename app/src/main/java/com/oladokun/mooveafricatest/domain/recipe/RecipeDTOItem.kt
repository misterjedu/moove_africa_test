package com.oladokun.mooveafricatest.domain.recipe

data class RecipeDTOItem(
    val id: Int,
    val image: String,
    val ingredients: List<Ingredient>,
    val name: String,
    val servings: Int,
    val steps: List<Step>
)