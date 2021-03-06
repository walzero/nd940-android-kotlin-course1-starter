package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.extensions.showAsShortToast

class LoginFragment : ShoeStoreFragment(
    hasLogoutFunction = false
) {

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

    private fun hasPassword(): Boolean =
        binding.passwordInput.text?.isNotBlank() ?: false

    private fun hasEmail(): Boolean =
        binding.emailInput.text?.isNotBlank() ?: false

    private fun showShortToast(message: String) {
        requireContext().showAsShortToast(message)
    }
}