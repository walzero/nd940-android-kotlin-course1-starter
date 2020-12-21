package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.extensions.showAsShortToast

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        binding.loginButton.setOnClickListener { attemptToLogin() }
        binding.registerLinkText.setOnClickListener { goToWelcomeScreen() }

        return binding.root
    }

    private fun attemptToLogin() {
        when {
            !hasEmail() && !hasPassword() ->
                showShortToast(getString(R.string.email_and_password_required))
            !hasEmail() -> showShortToast(getString(R.string.email_required))
            !hasPassword() -> showShortToast(getString(R.string.password_required))
            else -> goToWelcomeScreen()
        }
    }

    private fun goToWelcomeScreen() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController(this@LoginFragment).navigate(action)
    }

    private fun hasPassword(): Boolean {
        return binding.passwordInput.text?.isNotBlank() ?: false
    }

    private fun hasEmail(): Boolean {
        return binding.emailInput.text?.isNotBlank() ?: false
    }

    private fun showShortToast(message: String) {
        requireContext().showAsShortToast(message)
    }
}