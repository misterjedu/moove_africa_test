package com.oladokun.mooveafricatest.repository

import com.oladokun.mooveafricatest.domain.GenericApiResponse


/**
 * Following SOLID principle, the view model will interact with the abstraction rather than the
 * concrete class.
 */
interface RecipeRepository {
    suspend fun getRecipes(): GenericApiResponse
}