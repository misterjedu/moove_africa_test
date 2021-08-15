package com.oladokun.mooveafricatest.ui.recipe_details.recipe_ingredient_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oladokun.mooveafricatest.databinding.ItemRecipeIngredientsBinding
import com.oladokun.mooveafricatest.domain.recipe.Ingredient

class RecipeIngredientListAdapter :
    ListAdapter<Ingredient, RecipeIngredientViewHolder>(RecipeIngredientDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeIngredientViewHolder {
        val binding =
            ItemRecipeIngredientsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeIngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeIngredientViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

}