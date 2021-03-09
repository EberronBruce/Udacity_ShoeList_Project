package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment: Fragment() {

    private lateinit var viewModel: ShoeListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeListingBinding>(inflater, R.layout.fragment_shoe_listing, container, false)
        (activity as? MainActivity)?.fab?.show()



        viewModel = ViewModelProvider(this).get(ShoeListingViewModel::class.java)
        (activity as? MainActivity)?.fab?.setOnClickListener {

        }

        viewModel.shoeList.observe(this.viewLifecycleOwner, Observer { newShoeList ->
            binding.shoeLinearlayout.removeAllViews()
            for (shoe in newShoeList ) {
                val shoeLayout = layoutInflater.inflate(R.layout.shoe_layout, binding.shoeLinearlayout, false)
                shoeLayout.findViewById<TextView>(R.id.shoeCompanyText).text = shoe.company
                shoeLayout.findViewById<TextView>(R.id.shoeNameText).text = shoe.name
                binding.shoeLinearlayout.addView(shoeLayout)
            }
        })


        return binding.root
    }
}