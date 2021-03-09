package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.saveButton.setOnClickListener {  view: View ->
            val shoeName = binding.editShoeName.text.toString().trim()
            val company = binding.editCompany.text.toString().trim()
            val desc = binding.editShoeDesc.text.toString().trim()
            val size = binding.editSizeText.text.toString().trim()
            if(checkEditFields(shoeName, company, desc, size)) {
                (activity as? MainActivity)?.viewModel?.addShoes(shoeName, company, desc, size.toDouble())
                view.findNavController().popBackStack()
            }
        }

        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().popBackStack()
        }

        return binding.root
    }

    private fun checkEditFields(shoeName: String, company: String, desc: String, size: String): Boolean {

        if (shoeName.length > 0 && company.length > 0 && desc.length > 0 && size.length > 0) {
            return true
        }
        return false
    }
}