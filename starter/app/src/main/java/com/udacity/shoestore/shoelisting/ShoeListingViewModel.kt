package com.udacity.shoestore.shoelisting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListingViewModel: ViewModel() {

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

//    fun testShoes() {
//        //Timber.i("Test Shoes")
//        val test = _shoeList.value
//        test?.add(Shoe("Test", 11.2, "Test","its a test shoe"))
//        _shoeList.value = test
//        //Timber.i("${shoeList.value}")
//    }

}