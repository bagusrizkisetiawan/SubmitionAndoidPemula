package com.dicoding.submitionandoidpemula

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Language(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable