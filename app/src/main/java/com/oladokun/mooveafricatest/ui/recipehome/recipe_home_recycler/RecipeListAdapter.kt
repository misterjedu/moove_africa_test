package com.oladokun.mooveafricatest.ui.recipehome.recipe_home_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oladokun.mooveafricatest.databinding.ItemRecipeBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem
import com.oladokun.mooveafricatest.utils.Callback


class RecipeListAdapter(private val clickListener: Callback<Int>) :
    ListAdapter<RecipeDTOItem, RecipeViewHolder>(RecipeDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding =
            ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null)
            holder.bind(currentItem, clickListener)
    }
}

