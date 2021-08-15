package com.oladokun.mooveafricatest.ui.recipe_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.oladokun.mooveafricatest.databinding.FragmentRecipeDetailBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem
import com.oladokun.mooveafricatest.ui.shared.GenericViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : Fragment() {
    private lateinit var recipeIngredientViewPager: ViewPager2
    private lateinit var recipeIngredientTabLayout: TabLayout
    private lateinit var recipeIngredientAdapter: GenericViewPagerAdapter
    private val recipeDetailArgs by navArgs<RecipeDetailFragmentArgs>()
    private lateinit var recipeItem: RecipeDTOItem


    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)

        recipeItem = recipeDetailArgs.recipeItem
        recipeIngredientTabLayout = binding.fragmentRecipeDetailTabLayout
        recipeIngredientViewPager = binding.fragmentRecipeDetailViewPager

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.fragmentRecipeServingsText.text = recipeItem.servings.toString()

        val fragmentList =
            listOf(
                RecipeIngredientFragment.newInstance(recipeItem),
                RecipeStepsFragment()
            )

        recipeIngredientAdapter = GenericViewPagerAdapter(
            childFragmentManager, lifecycle,
            fragmentList as MutableList<Fragment>
        )

        recipeIngredientViewPager.adapter = recipeIngredientAdapter


        TabLayoutMediator(recipeIngredientTabLayout, recipeIngredientViewPager)
        { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Ingredients"
                }
                1 -> {
                    tab.text = "Steps"
                }
            }
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}