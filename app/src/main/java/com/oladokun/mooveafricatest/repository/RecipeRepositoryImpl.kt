package com.oladokun.mooveafricatest.repository

import com.oladokun.mooveafricatest.domain.ApiService
import com.oladokun.mooveafricatest.domain.GenericApiResponse
import javax.inject.Inject

/**
 * Api Service is injected to the repository constructor. It extends the repository interface
 */
class RecipeRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    RecipeRepository {

    /**
     * The response from api call is wrapped in success or error depending on the
     * status.
     */
    override suspend fun getRecipes(): GenericApiResponse {
        return try {
            GenericApiResponse.Success(apiService.registerUser())
        } catch (e: Exception) {
            GenericApiResponse.Error("An error occured")
        }
    }
}