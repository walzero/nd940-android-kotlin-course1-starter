package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    private val _shoesData: MutableLiveData<MutableList<Shoe>> = MutableLiveData(mutableListOf())
    val shoesData: LiveData<List<Shoe>>
        get() = Transformations.map(_shoesData) { it.toList() }

    fun addShoe(shoe: Shoe?) {
        Timber.i("SIZE VALUE: ${shoe?.size}")
        shoe?.let { _shoesData.value?.add(it) }
    }

    val currentShoe: MutableLiveData<Shoe> = MutableLiveData()
}