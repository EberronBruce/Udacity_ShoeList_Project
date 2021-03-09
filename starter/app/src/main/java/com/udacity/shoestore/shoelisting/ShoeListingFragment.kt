package com.udacity.shoestore.shoelisting

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListingBinding

class ShoeListingFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentShoeListingBinding>(inflater, R.layout.fragment_shoe_listing, container, false)
        (activity as? MainActivity)?.fab?.show()

        (activity as? MainActivity)?.fab?.setOnClickListener { view: View ->
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }

        val viewModel = (activity as? MainActivity)?.viewModel
        viewModel?.shoeList?.observe(this.viewLifecycleOwner, Observer { newShoeList ->
            //This is not as effective as RecylerView. But the class instructions call for this. The more view that are created the more memory taken up which can lead issues.
            binding.shoeLinearlayout.removeAllViews()
            for (shoe in newShoeList ) {
                val shoeLayout = layoutInflater.inflate(R.layout.shoe_layout, binding.shoeLinearlayout, false)
                shoeLayout.findViewById<TextView>(R.id.shoeCompanyText).text = shoe.company
                shoeLayout.findViewById<TextView>(R.id.shoeNameText).text = shoe.name
                binding.shoeLinearlayout.addView(shoeLayout)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    //    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        super.onCreateOptionsMenu(menu, inf)
//        menuInflater.inflate(R.menu.logout_menu, menu)
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }
}