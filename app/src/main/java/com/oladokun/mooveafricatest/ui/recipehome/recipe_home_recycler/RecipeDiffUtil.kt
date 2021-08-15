package com.oladokun.mooveafricatest.ui.recipehome.recipe_home_recycler

import androidx.recyclerview.widget.DiffUtil
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem


/**
 * Diff util to help optimize recycler view adapter
 */
class RecipeDiffUtil : DiffUtil.ItemCallback<RecipeDTOItem>() {
    override fun areItemsTheSame(oldItem: RecipeDTOItem, newItem: RecipeDTOItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RecipeDTOItem, newItem: RecipeDTOItem) =
        oldItem == newItem
}