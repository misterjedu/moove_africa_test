package com.oladokun.mooveafricatest.ui.recipehome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.oladokun.mooveafricatest.databinding.FragmentRecipeHomeBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem
import com.oladokun.mooveafricatest.ui.recipehome.recipe_home_recycler.RecipeListAdapter
import com.oladokun.mooveafricatest.utils.fragmentSlideInLeftAnimation
import com.oladokun.mooveafricatest.viewmodels.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeHomeFragment : Fragment() {


    private val recipeViewModel: RecipeViewModel by viewModels()

    private var _binding: FragmentRecipeHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var recipeRecyclerAdapter: RecipeListAdapter
    private var recipeList: MutableList<RecipeDTOItem> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentRecipeHomeBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeRecyclerView = binding.recipeRecyclerView

        recipeRecyclerAdapter = RecipeListAdapter { adapterPostion ->

            val selectedRecipe = recipeList[adapterPostion]

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

        recipeViewModel.recipes.observe(viewLifecycleOwner, {
            recipeList = it
            recipeRecyclerAdapter.submitList(it)
        })
    }


}