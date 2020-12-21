package com.udacity.shoestore.extensions

import android.content.Context
import android.widget.Toast

fun Context.showAsShortToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}