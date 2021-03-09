package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)
        //use to hide the floating action button so it only shows up later
        (activity as? MainActivity)?.fab?.hide()
        //use to hide the action bar because unable to hide the menu
        (activity as MainActivity).supportActionBar?.hide()

        binding.loginButton.setOnClickListener {  view: View ->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.createLoginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }


        return binding.root
    }

}