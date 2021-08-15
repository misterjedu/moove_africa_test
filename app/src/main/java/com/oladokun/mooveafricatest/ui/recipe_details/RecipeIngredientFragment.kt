package com.oladokun.mooveafricatest.ui.recipe_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.oladokun.mooveafricatest.databinding.FragmentRecipeIngredientBinding
import com.oladokun.mooveafricatest.domain.recipe.RecipeDTOItem
import com.oladokun.mooveafricatest.ui.recipe_details.recipe_ingredient_recycler.RecipeIngredientListAdapter


private const val RECIPE_ITEM = "ingredient"

class RecipeIngredientFragment : Fragment() {

    private var _binding: FragmentRecipeIngredientBinding? = null
    private val binding get() = _binding!!
    private var recipeItem: RecipeDTOItem? = null
    private lateinit var recipeIngredientRecyclerView: RecyclerView
    private lateinit var recipeIngredientLisAdapter: RecipeIngredientListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //The Recipe Item is retrieved here from the bundle
        arguments?.let {
            recipeItem = it.getParcelable(RECIPE_ITEM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentRecipeIngredientBinding.inflate(inflater, container, false)

        recipeIngredientRecyclerView = binding.fragmentRecipeIngredientRecyclerView
        recipeIngredientLisAdapter = RecipeIngredientListAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeIngredientRecyclerView.adapter = recipeIngredientLisAdapter

        recipeItem?.let {
            recipeIngredientLisAdapter.submitList(it.ingredients)
        }

    }

    //The Recipe Item is passed to the fragment as bundle when initialized.
    companion object {
        @JvmStatic
        fun newInstance(recipeDTOItem: RecipeDTOItem) =
            RecipeIngredientFragment().apply {
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