package com.oladokun.mooveafricatest.ui.recipe_details.recipe_ingredient_recycler

import androidx.recyclerview.widget.RecyclerView
import com.oladokun.mooveafricatest.databinding.ItemRecipeIngredientsBinding
import com.oladokun.mooveafricatest.domain.recipe.Ingredient

class RecipeIngredientViewHolder(private val binding: ItemRecipeIngredientsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(ingredient: Ingredient) {

        binding.apply {
            itemRecipeStepsIngredientValue.text = ingredient.ingredient
            itemRecipeStepsMeasurementValue.text = ingredient.measure
            itemRecipeStepsQuantityValue.text = ingredient.quantity.toString()
        }

    }
}