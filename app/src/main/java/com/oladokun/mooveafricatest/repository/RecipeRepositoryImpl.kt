package com.oladokun.mooveafricatest.repository

import com.oladokun.mooveafricatest.domain.ApiService
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTO
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    RecipeRepository {
    override suspend fun getRecipes(): RecipeDTO {
        return apiService.registerUser()
    }
}