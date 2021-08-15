package com.oladokun.mooveafricatest.domain

import com.oladokun.mooveafricatest.domain.recipe.RecipeDTO

//Sealed class to wrap api response with the data state.
sealed class GenericApiResponse {
    object Loading : GenericApiResponse()
    data class Success(val recipes: RecipeDTO) : GenericApiResponse()
    data class Error(val errorMessage: String) : GenericApiResponse()
}