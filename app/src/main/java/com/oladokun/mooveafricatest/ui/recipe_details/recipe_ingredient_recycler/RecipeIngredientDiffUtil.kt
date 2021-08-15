package com.oladokun.mooveafricatest.ui.recipe_details.recipe_ingredient_recycler

import androidx.recyclerview.widget.DiffUtil
import com.oladokun.mooveafricatest.domain.recipe.Ingredient

/**
 * Diff util to help optimize recycler view adapter
 */
class RecipeIngredientDiffUtil : DiffUtil.ItemCallback<Ingredient>() {
    override fun areItemsTheSame(oldItem: Ingredient, newItem: Ingredient) =
        oldItem.ingredient == newItem.ingredient

    override fun areContentsTheSame(oldItem: Ingredient, newItem: Ingredient) =
        oldItem == newItem
}