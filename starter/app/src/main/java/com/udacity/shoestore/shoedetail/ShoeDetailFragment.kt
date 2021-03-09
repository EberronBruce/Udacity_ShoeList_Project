package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment: Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as? MainActivity)?.fab?.hide()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.showListingViewModel = (activity as? MainActivity)?.viewModel
        binding.lifecycleOwner = this
        val viewModel = (activity as? MainActivity)?.viewModel
        viewModel?.eventClose?.observe(this.viewLifecycleOwner, Observer { close ->
            if (close) {
                findNavController().popBackStack()
                viewModel.finishExit()
            }

        })

        return binding.root
    }


}