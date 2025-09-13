package com.example.assessment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.FieldPosition
import kotlin.collections.orEmpty
import kotlin.collections.plus

class CafesViewModel {
    private val _cafes = MutableLiveData<List<Cafe>>(emptyList())
    val cafes: LiveData<List<Cafe>> = _cafes

    fun favourite(position: Int) {
        _cafes.value = _cafes.value?.mapIndexed { index, cafe ->
            if (index == position) cafe.copy(isFavourited = !cafe.isFavourited)
            else cafe
        }
    }

    // for adding cafes later
    fun add(cafe: Cafe) {
        _cafes.value =_cafes.value.orEmpty() + cafe
    }
}