package com.oladokun.mooveafricatest.shared

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oladokun.mooveafricatest.R
import com.oladokun.mooveafricatest.databinding.ItemRecipeBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem


class RecipeViewHolder(private val binding: ItemRecipeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: RecipeDTOItem) {

        binding.apply {

            var imageView = 0

            when (recipe.id) {
                0 -> {
                    imageView = R.drawable.nutela
                }
                1 -> {
                    imageView = R.drawable.brownies
                }
                2 -> {
                    imageView = R.drawable.yellow_cake
                }

                else -> {
                    imageView = R.drawable.brownies

                }

            }

            Glide.with(itemView)
                .load(imageView)
                .error(R.drawable.placeholder)
                .into(recipeImage)

            recipeName.text = recipe.name
        }

    }
}