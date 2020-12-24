package com.udacity.shoestore

import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter


object ShoeSizeConverter {

    @BindingAdapter("android:text")
    @JvmStatic
    fun toString(
        view: EditText,
        value: Double
    ) {
        view.setText(value.toString()
            .formatNumber()
            .removeSuffix(".0")
            .removeSuffix(".")
            .takeUnless { it == "0" }
        )

        view.setSelection(view.text.length, view.text.length)
    }

    @InverseBindingAdapter(attribute = "android:text")
    @JvmStatic
    fun toDouble(
        view: EditText
    ): Double = try {
        val number = view.text.toString().toDouble()

        val newNumber = view.text.toString()
            .formatNumber()
            .toDouble()

        if (newNumber != number) {
            toString(view, newNumber)
        }

        number
    } catch (e: NumberFormatException) {
        0.0
    }

    private fun String.formatNumber(): String {
        val numberParts = this.split(".")

        val integerPart = when (numberParts[0].length) {
            0 -> "0"
            1, 2 -> numberParts[0]
            else -> numberParts[0].substring(0, 2)
        }

        val decimalPart = when {
            numberParts.size == 1 && numberParts[0].length > 2 -> numberParts[0][2]
            numberParts.size == 1 -> "0"
            numberParts[1].isEmpty() -> "0"
            numberParts[1].length == 1 -> numberParts[1]
            else -> numberParts[1].substring(0, 1)
        }

        return "$integerPart.$decimalPart"
    }
}