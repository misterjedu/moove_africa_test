package com.oladokun.mooveafricatest.repository

import com.oladokun.mooveafricatest.domain.ApiService
import com.oladokun.mooveafricatest.domain.GenericApiResponse
import javax.inject.Inject

class RecipeRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    RecipeRepository {
    override suspend fun getRecipes(): GenericApiResponse {
        return try {
            GenericApiResponse.Success(apiService.registerUser())
        } catch (e: Exception) {
            GenericApiResponse.Error("An error occured")
        }
    }
}