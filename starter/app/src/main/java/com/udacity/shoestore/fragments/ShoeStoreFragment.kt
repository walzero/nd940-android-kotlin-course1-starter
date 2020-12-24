package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel

open class ShoeStoreFragment(
    private val hasLogoutFunction: Boolean = true
) : BaseNavigationFragment() {

    protected val shoeViewModel by lazy {
        ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
    }

    open fun navigateBackToLogin() {}

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
            R.id.logoutMenuButton -> {
                shoeViewModel.clearShoes()
                navigateBackToLogin()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}