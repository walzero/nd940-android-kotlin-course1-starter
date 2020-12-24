package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListAdapter
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe

class ShoeListFragment: BaseNavigationFragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val shoeListAdapter by lazy { ShoeListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        binding.shoeListFab.setOnClickListener { goToDetailScreen() }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoeList.apply {
            adapter = shoeListAdapter
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        }
    }

    private fun goToDetailScreen() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        NavHostFragment.findNavController(this@ShoeListFragment).navigate(action)
    }

    private val mockShoe by lazy {
        Shoe(
            name = "Air Jordan max jump",
            size = 42.0,
            description = "Great basketball shoes",
            company = "Nike",
            images = listOf()
        )
    }
}