package com.udacity.shoestore.shoelisting

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListingViewModel: ViewModel() {

    val shoeName = ObservableField<String>("")
    val companyName = ObservableField<String>("")
    val description = ObservableField<String>("")
    val size = ObservableField<String>("")

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _eventClose = MutableLiveData<Boolean>()
    val eventClose: LiveData<Boolean>
        get() = _eventClose

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

    fun addShoes() {
        val shoeName = this.shoeName.get()?.trim()
        val company = this.companyName.get()?.trim()
        val desc = this.description.get()?.trim()
        val size = this.size.get()?.trim()

        if(isAllInformationValid(shoeName, company, desc, size)) {
            val oldList = _shoeList.value
            oldList?.add(Shoe(shoeName!!, size!!.toDouble(), company!!, desc!!))
            _shoeList.value = oldList
            onExit()
        }
    }

    private fun isAllInformationValid(shoeName: String?, company: String?, desc: String?, size: String?): Boolean {
        if (size != null && company != null && shoeName != null && desc != null) {
            if(size.isNotEmpty() && company.isNotEmpty() && shoeName.isNotEmpty() && desc.isNotEmpty()) {
                if(size.toDouble().isNaN()) {
                    return false
                }
                return true
            }
        }
        return false
    }

    fun onExit() {
        _eventClose.value = true
    }

    fun finishExit() {
        _eventClose.value = false
    }
}