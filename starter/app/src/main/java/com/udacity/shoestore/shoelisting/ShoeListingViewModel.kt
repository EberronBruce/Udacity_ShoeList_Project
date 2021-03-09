package com.udacity.shoestore.shoelisting

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeListingViewModel: ViewModel() {

    val shoeName = ObservableField<String>()

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        setupShoes()
    }

    private fun setupShoes() {
        _shoeList.value = mutableListOf(
                Shoe("Running Shoes", 12.2, "Nike","Pair of Nike Running Shoes"),
                Shoe("Tennis Shoes", 10.0, "ADIAS","Pair of Tennis Shoes"),
                Shoe("Slippers", 6.5, "Bear","Pair of Slippers"),
                Shoe("Monkey Paws", 11.2, "Nike","its a test shoe")
        )
    }

    fun addShoes(name: String, company: String, desc: String, size: Double) {
        val oldList = _shoeList.value
        oldList?.add(Shoe(name, size, company, desc))
        _shoeList.value = oldList
    }

    fun onTest(v: View) {
        Timber.i("This is a test")
    }


}