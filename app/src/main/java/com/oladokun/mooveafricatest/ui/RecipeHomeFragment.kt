package com.oladokun.mooveafricatest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.oladokun.mooveafricatest.databinding.FragmentRecipeHomeBinding
import com.oladokun.mooveafricatest.shared.RecipeListAdapter
import com.oladokun.mooveafricatest.viewmodels.RecipeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeHomeFragment : Fragment() {


    private val recipeViewModel: RecipeViewModel by viewModels()

    private var _binding: FragmentRecipeHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recipeRecyclerView: RecyclerView
    private lateinit var recipeRecyclerAdapter: RecipeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentRecipeHomeBinding.inflate(inflater, container, false)

        recipeRecyclerView = binding.recipeRecyclerView
        recipeRecyclerAdapter = RecipeListAdapter()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recipeRecyclerView.apply {
            adapter = recipeRecyclerAdapter
            setHasFixedSize(true)
        }

        recipeViewModel.recipes.observe(viewLifecycleOwner, {
            recipeRecyclerAdapter.submitList(it)
        })
    }


}