package com.example.assessment1
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cafe(
    val title: String,
    val description: String,
    val category: String,
    val imageID: Int,
    var isFavourited: Boolean = false
) : Parcelable
