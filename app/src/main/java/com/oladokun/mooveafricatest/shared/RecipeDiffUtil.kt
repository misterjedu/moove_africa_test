package com.oladokun.mooveafricatest.shared

import androidx.recyclerview.widget.DiffUtil
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem


class RecipeDiffUtil : DiffUtil.ItemCallback<RecipeDTOItem>() {
    override fun areItemsTheSame(oldItem: RecipeDTOItem, newItem: RecipeDTOItem) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: RecipeDTOItem, newItem: RecipeDTOItem) =
        oldItem == newItem
}