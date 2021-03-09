package com.udacity.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(inflater, R.layout.fragment_welcome, container, false)
        //use to hide the action bar because unable to hide the menu
        (activity as MainActivity).supportActionBar?.show()

        binding.welcomeContinueButton.setOnClickListener { view: View ->
            view.findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }

        return binding.root
    }
}