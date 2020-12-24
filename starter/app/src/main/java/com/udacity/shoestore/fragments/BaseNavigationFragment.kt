package com.udacity.shoestore.fragments

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseNavigationFragment : Fragment() {
    open fun popCurrentFragment() = findNavController().popBackStack()
}