package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController: NavController
        get() = findNavController(R.id.nav_host_fragment)

    private lateinit var shoeViewModel: ShoeViewModel

    private lateinit var binding: ActivityMainBinding

    private val onDestinationChangedListener by lazy {
        NavController.OnDestinationChangedListener { _, destination, _ ->
            title = destination.label
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
    }

    override fun onStart() {
        super.onStart()
        NavigationUI.setupActionBarWithNavController(this, navController)
        navController.addOnDestinationChangedListener(onDestinationChangedListener)
    }

    override fun onStop() {
        super.onStop()
        navController.removeOnDestinationChangedListener(onDestinationChangedListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.popBackStack().takeIf { it } ?: onLastFragmentBackPressed()
    }

    private fun onLastFragmentBackPressed(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
