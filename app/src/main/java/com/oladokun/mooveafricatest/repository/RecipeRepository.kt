package com.oladokun.mooveafricatest.repository

import com.oladokun.mooveafricatest.domain.GenericApiResponse


interface RecipeRepository {
    suspend fun getRecipes(): GenericApiResponse
}