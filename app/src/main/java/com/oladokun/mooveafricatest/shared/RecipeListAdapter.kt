package com.oladokun.mooveafricatest.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oladokun.mooveafricatest.databinding.ItemRecipeBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem


class RecipeListAdapter :
    ListAdapter<RecipeDTOItem, RecipeViewHolder>(RecipeDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

}