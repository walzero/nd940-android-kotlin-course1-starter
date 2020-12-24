package com.udacity.shoestore.fragments

import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.ShoeViewModel

open class ShoeStoreFragment(
    hasLogoutFunction: Boolean = true
): BaseNavigationFragment(hasLogoutFunction) {
    protected val shoeViewModel by lazy {
        ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
    }
}