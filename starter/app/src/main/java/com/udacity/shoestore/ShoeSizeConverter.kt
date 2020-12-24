package com.udacity.shoestore

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter


object ShoeSizeConverter {

    @BindingAdapter("android:text")
    @JvmStatic
    fun toString(
        view: EditText,
        value: Double?
    ) {
        view.setText(value?.toString())
        view.setSelection(view.text.length, view.text.length)
    }

    @InverseBindingAdapter(attribute = "android:text")
    @JvmStatic
    fun toDouble(
        view: EditText
    ): Double? = try {
        view.text.toString().toDouble()
    } catch (e: NumberFormatException) {
        null
    }
}