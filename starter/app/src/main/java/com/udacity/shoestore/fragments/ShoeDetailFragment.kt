package com.udacity.shoestore.fragments

import android.os.Bundle
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment: ShoeStoreFragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shoe_detail,
            container,
            false
        )

        shoeViewModel.currentShoe.value = Shoe()

        binding.viewmodel = shoeViewModel

        binding.cancelButton.setOnClickListener { popCurrentFragment() }
        binding.saveButton.setOnClickListener {
            shoeViewModel.addShoe(shoeViewModel.currentShoe.value)
            popCurrentFragment()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameInput.filters = arrayOf(InputFilter.LengthFilter(MAX_NAME))
        binding.brandInput.filters = arrayOf(InputFilter.LengthFilter(MAX_BRAND))
        binding.descriptionInput.filters = arrayOf(InputFilter.LengthFilter(MAX_DESCRIPTION))
    }

    companion object {
        const val MAX_NAME = 48
        const val MAX_BRAND = 16
        const val MAX_DESCRIPTION = 200
    }
}