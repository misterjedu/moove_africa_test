package com.oladokun.mooveafricatest.ui.recipe_details.recycler_steps_recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.oladokun.mooveafricatest.databinding.ItemRecipeStepsBinding
import com.oladokun.mooveafricatest.domain.recipe.Step

class RecipeStepsListAdapter :
    ListAdapter<Step, RecipeStepsViewHolder>(RecipeStepsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeStepsViewHolder {
        val binding =
            ItemRecipeStepsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeStepsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeStepsViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

}