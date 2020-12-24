package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R

abstract class BaseNavigationFragment(
    private val hasLogoutFunction: Boolean = true
) : Fragment() {

    open fun navigateBackToLogin() {}

    open fun popCurrentFragment() = findNavController().popBackStack()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.logoutMenuButton)?.isVisible = hasLogoutFunction
        super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logoutMenuButton -> navigateBackToLogin()
        }
        return super.onOptionsItemSelected(item)
    }
}