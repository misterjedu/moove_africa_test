package com.oladokun.mooveafricatest.ui.recipe_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.oladokun.mooveafricatest.databinding.FragmentRecipeStepsBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem
import com.oladokun.mooveafricatest.ui.recipe_details.recycler_steps_recycler.RecipeStepsListAdapter

private const val RECIPE_ITEM = "recipe_item"

class RecipeStepsFragment : Fragment() {

    private var _binding: FragmentRecipeStepsBinding? = null
    private val binding get() = _binding!!
    private var recipeItem: RecipeDTOItem? = null
    private lateinit var recipeStepRecyclerView: RecyclerView
    private lateinit var recipeStepLisAdapter: RecipeStepsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            recipeItem = it.getParcelable(RECIPE_ITEM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecipeStepsBinding.inflate(inflater, container, false)
        recipeStepRecyclerView = binding.fragmentRecipeStepRecyclerView
        recipeStepLisAdapter = RecipeStepsListAdapter()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recipeStepRecyclerView.adapter = recipeStepLisAdapter

        recipeItem?.let {
            recipeStepLisAdapter.submitList(it.steps)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(recipeDTOItem: RecipeDTOItem) =
            RecipeStepsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(RECIPE_ITEM, recipeDTOItem)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}