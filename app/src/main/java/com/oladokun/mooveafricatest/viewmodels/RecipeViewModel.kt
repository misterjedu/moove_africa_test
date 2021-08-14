package com.oladokun.mooveafricatest.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTO
import com.oladokun.mooveafricatest.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    ViewModel() {

    private var _recipes: MutableLiveData<RecipeDTO> = MutableLiveData()
    var recipes: LiveData<RecipeDTO> = _recipes

    init {
        getRecipes()
    }

    fun getRecipes() {
        viewModelScope.launch {
            _recipes.value = recipeRepository.getRecipes()
        }
    }


}