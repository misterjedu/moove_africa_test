package com.oladokun.mooveafricatest.ui.recipehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.oladokun.mooveafricatest.databinding.FragmentRecipeHomeBinding
import com.oladokun.mooveafricatest.domain.GenericApiResponse
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem
import com.oladokun.mooveafricatest.ui.recipehome.recipe_home_recycler.RecipeListAdapter
import com.oladokun.mooveafricatest.utils.fragmentSlideInLeftAnimation
import com.oladokun.mooveafricatest.utils.hideVisibility
import com.oladokun.mooveafricatest.utils.showVisibility
import com.oladokun.mooveafricatest.viewmodels.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint
import pl.droidsonroids.gif.GifImageView

@AndroidEntryPoint
class RecipeHomeFragment : Fragment() {


    private val recipeViewModel: RecipeViewModel by viewModels()

    private var _binding: FragmentRecipeHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var recipeRecyclerAdapter: RecipeListAdapter
    private var recipeList: MutableList<RecipeDTOItem> = mutableListOf()
    private lateinit var loadingScreen: GifImageView
    private lateinit var offlineScreen: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentRecipeHomeBinding.inflate(inflater, container, false)
        recipeRecyclerView = binding.recipeRecyclerView
        loadingScreen = binding.recipeImageHomeLoading
        offlineScreen = binding.recipeImageHomeOffline

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
            Recycler Adapter click listener. Onclick of an recycler item, the position is passed
            to the callback lambda and navigate the recipe detail fragment
         */
        recipeRecyclerAdapter = RecipeListAdapter { adapterPosition ->

            val selectedRecipe = recipeList[adapterPosition]

            val action =
                RecipeHomeFragmentDirections.actionRecipeHomeFragmentToRecipeDetailFragment(
                    selectedRecipe
                )

            findNavController().navigate(action, fragmentSlideInLeftAnimation().build())
        }

        recipeRecyclerView.apply {
            adapter = recipeRecyclerAdapter
            setHasFixedSize(true)
        }


        //Observe recipes from recipe view model live data
        recipeViewModel.recipes.observe(viewLifecycleOwner, {
            when (it) {
                is GenericApiResponse.Loading -> {
                    swapVisibleScreen(loadingScreen)
                }
                is GenericApiResponse.Error -> {
                    swapVisibleScreen(offlineScreen)
                }
                is GenericApiResponse.Success -> {
                    recipeList = it.recipes
                    recipeRecyclerAdapter.submitList(it.recipes)
                    swapVisibleScreen(recipeRecyclerView)
                }
            }

        })

        binding.fragmentRecipeHomeRefreshButton.setOnClickListener {
            swapVisibleScreen(loadingScreen)
            recipeViewModel.getRecipes()
        }
    }

    private fun swapVisibleScreen(screenToShow: View) {
        recipeRecyclerView.hideVisibility()
        loadingScreen.hideVisibility()
        offlineScreen.hideVisibility()
        screenToShow.showVisibility()
    }

}