package com.oladokun.mooveafricatest.domain

import com.oladokun.mooveafricatest.domain.recipe.RecipeDTO
import retrofit2.http.GET

interface ApiService {

    // Get recipes
    @GET("topher/2017/May/59121517_baking/baking.json")
    suspend fun registerUser(): RecipeDTO
}
