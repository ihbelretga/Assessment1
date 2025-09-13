package com.example.assessment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.FieldPosition
import kotlin.collections.orEmpty
import kotlin.collections.plus

class CafesViewModel {
    private val _cafes = MutableLiveData<List<Cafe>>(
listOf(
            Cafe("Example cafe title", "Some kinda description", "Northbridge", android.R.color.darker_gray),
            Cafe("Example cafe 2 title", "Some kinda description", "Fremantle", android.R.color.darker_gray)
        )
    )
    val cafes: LiveData<List<Cafe>> get() = _cafes

    fun toggleFavourite(cafe: Cafe) {
        cafe.isFavourited = !cafe.isFavourited
        _cafes.value = _cafes.value.orEmpty()
    }
}
