package com.oladokun.mooveafricatest.repository

import com.oladokun.mooveafricatest.domain.recipe.RecipeDTO


interface RecipeRepository {
    suspend fun getRecipes(): RecipeDTO
}