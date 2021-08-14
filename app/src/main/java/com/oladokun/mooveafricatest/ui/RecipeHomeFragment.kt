package com.oladokun.mooveafricatest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.oladokun.mooveafricatest.R
import com.oladokun.mooveafricatest.databinding.FragmentRecipeDetailBinding
import com.oladokun.mooveafricatest.databinding.FragmentRecipeHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeHomeFragment : Fragment() {

    private var _binding: FragmentRecipeHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        _binding = FragmentRecipeHomeBinding.inflate(inflater, container, false)

        button = binding.recipeHomeButton
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            findNavController().navigate(R.id.recipeDetailFragment)
        }
    }


}