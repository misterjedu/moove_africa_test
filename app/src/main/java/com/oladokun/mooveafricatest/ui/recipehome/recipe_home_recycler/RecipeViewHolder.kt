package com.oladokun.mooveafricatest.ui.recipehome.recipe_home_recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oladokun.mooveafricatest.R
import com.oladokun.mooveafricatest.databinding.ItemRecipeBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem
import com.oladokun.mooveafricatest.utils.Callback


class RecipeViewHolder(private val binding: ItemRecipeBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(recipe: RecipeDTOItem, clickListener: Callback<Int>) {

        binding.apply {


            itemRecipeParent.setOnClickListener {
                clickListener(adapterPosition)
            }


            var imageView = 0

            when (recipe.id) {
                1 -> {
                    imageView = R.drawable.nutela
                }
                2 -> {
                    imageView = R.drawable.brownies
                }
                3 -> {
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