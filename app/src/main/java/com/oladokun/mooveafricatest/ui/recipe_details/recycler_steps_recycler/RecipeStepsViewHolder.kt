package com.oladokun.mooveafricatest.ui.recipe_details.recycler_steps_recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oladokun.mooveafricatest.R
import com.oladokun.mooveafricatest.databinding.ItemRecipeStepsBinding
import com.oladokun.mooveafricatest.domain.recipe.Step

class RecipeStepsViewHolder(private val binding: ItemRecipeStepsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    //The view holder receives an step item

    fun bind(step: Step) {

        binding.apply {

            //The step item is used to populate all step fields.

            itemRecipeStepValue.text = (step.id).toString()
            itemRecipeStepShortDescValue.text = step.shortDescription
            itemRecipeStepDescriptionValue.text = step.description

            //Since there's no thumbnail from the api, random images are used.
            val imageView: Int = when ((Math.random() * 5).toInt()) {
                1 -> {
                    R.drawable.nutela
                }
                2 -> {
                    R.drawable.brownies
                }
                3 -> {
                    R.drawable.yellow_cake
                }

                else -> {
                    R.drawable.brownies
                }
            }

            Glide.with(itemView)
                .load(imageView)
                .error(R.drawable.placeholder)
                .into(itemRecipeStepImage)
        }

    }
}