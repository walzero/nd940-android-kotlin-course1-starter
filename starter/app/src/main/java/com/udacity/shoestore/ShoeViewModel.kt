package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {

    private val _shoesData: MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    val shoesData: LiveData<List<Shoe>>
        get() = Transformations.map(_shoesData) { it.toList() }

    init {
        _shoesData.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe?) {
        shoe?.run {
            size = size ?: 0.0
            _shoesData.value?.add(this)
        }
    }

    var currentShoe: Shoe = Shoe()
}