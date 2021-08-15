package com.oladokun.mooveafricatest.ui.recipe_details.recycler_steps_recycler

import androidx.recyclerview.widget.DiffUtil
import com.oladokun.mooveafricatest.domain.recipe.Step

/**
 * Diff util to help optimize recycler view adapter
 */
class RecipeStepsDiffUtil : DiffUtil.ItemCallback<Step>() {
    override fun areItemsTheSame(oldItem: Step, newItem: Step) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Step, newItem: Step) =
        oldItem == newItem
}