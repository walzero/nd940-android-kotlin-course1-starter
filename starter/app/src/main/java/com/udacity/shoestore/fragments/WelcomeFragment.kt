package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : BaseNavigationFragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        binding.instructionsButton.setOnClickListener { goToInstructionsFragment() }

        return binding.root
    }

    private fun goToInstructionsFragment() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
        NavHostFragment.findNavController(this@WelcomeFragment).navigate(action)
    }

    override fun navigateBackToLogin() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToLoginFragment()
        NavHostFragment.findNavController(this@WelcomeFragment).navigate(action)
    }
}