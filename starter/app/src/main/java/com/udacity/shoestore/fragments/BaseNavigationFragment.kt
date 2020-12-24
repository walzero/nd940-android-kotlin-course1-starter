package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R

abstract class BaseNavigationFragment : Fragment() {
    open fun popCurrentFragment() = findNavController().popBackStack()
}