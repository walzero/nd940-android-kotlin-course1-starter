package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var name: String = "",
    var size: Double? = null,
    var company: String = "",
    var description: String = "",
    @DrawableRes val images: Int = -1
) : Parcelable