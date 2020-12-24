package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe
import java.util.*


class ShoeListFragment : ShoeStoreFragment() {

    private lateinit var binding: FragmentShoeListBinding

//Unused without recyclerview
//    private val shoeListAdapter by lazy { ShoeListAdapter() }

//Unused without recyclerview
//    private val shoeObserver: Observer<List<Shoe>?> = Observer { shoes ->
//        shoes?.let { shoeListAdapter.replaceShoes(it) }
//    }

    private val shoeObserver: Observer<List<Shoe>?> = Observer { shoes ->
        shoes?.let { items -> addItemsToLinearLayout(items) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate(
            inflater,
            R.layout.fragment_shoe_list,
            container,
            false
        )

        binding.lifecycleOwner = requireActivity()

        shoeViewModel.shoesData.observe(requireActivity(), shoeObserver)
        binding.shoeListFab.setOnClickListener { goToDetailScreen() }

        return binding.root
    }

    private fun addItemsToLinearLayout(shoes: List<Shoe>) {
        binding.shoeList.removeAllViews()
        shoes.forEach {
            inflateShoeItemView(it)
        }
    }

    private fun inflateShoeItemView(shoe: Shoe) {
        val shoeBinding = ItemShoeBinding.inflate(
            LayoutInflater.from(binding.shoeList.context),
            binding.shoeList,
            true
        )

        shoeBinding.shoe = shoe
    }

//Unused without recyclerview
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding.shoeList.apply {
//            adapter = shoeListAdapter
//            addItemDecoration(
//                DividerItemDecoration(
//                    requireContext(),
//                    DividerItemDecoration.VERTICAL
//                )
//            )
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        shoeViewModel.shoesData.removeObserver(shoeObserver)
    }

    private fun goToDetailScreen() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        NavHostFragment.findNavController(this@ShoeListFragment).navigate(action)
    }

    override fun navigateBackToLogin() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
        NavHostFragment.findNavController(this@ShoeListFragment).navigate(action)
    }
}