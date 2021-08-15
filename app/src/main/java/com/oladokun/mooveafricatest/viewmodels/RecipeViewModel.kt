package com.oladokun.mooveafricatest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oladokun.mooveafricatest.domain.GenericApiResponse
import com.oladokun.mooveafricatest.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * The @HiltViewModel to make the view model for DI by hilt, and inject the repository
 * interface through construction injection
 */
@HiltViewModel
class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    private var _recipes: MutableLiveData<GenericApiResponse> = MutableLiveData()
    var recipes: LiveData<GenericApiResponse> = _recipes

    /*
     The get recipes function is called immediately the view model is initialized
    */
    init {

        //Initial state of recipe should be loading
        _recipes.value = GenericApiResponse.Loading
        getRecipes()
    }

    fun getRecipes() {
        /*Coroutine launched to perform the network call on a background thread.
        The result from the repository is assigned to the recipes live data */
        _recipes.value = GenericApiResponse.Loading
        viewModelScope.launch {
            _recipes.value = recipeRepository.getRecipes()
        }
    }


}