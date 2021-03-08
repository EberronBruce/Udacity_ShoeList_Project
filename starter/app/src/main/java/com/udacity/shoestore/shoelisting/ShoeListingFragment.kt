package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import timber.log.Timber

class ShoeListingFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeListingBinding>(inflater, R.layout.fragment_shoe_listing, container, false)
        (activity as? MainActivity)?.fab?.show()
        (activity as? MainActivity)?.fab?.setOnClickListener {
            Timber.i("FLOAT CLICKED")
        }

        //activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.loginFragment, this)
        //activity?.supportFragmentManager?.popBackStack()


        return binding.root
    }
}