package com.example.assessment1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.text.FieldPosition
import kotlin.collections.orEmpty
import kotlin.collections.plus

class CafesViewModel {
    private val _cafes = MutableLiveData<List<Cafe>>(
listOf(
            Cafe("Guilty Pleasure", "A Korean dessert cafe that offers a wide range of beverages, cube toasts, croffles and cakes", "Northbridge", R.drawable.guiltypleasure),
            Cafe("Camellia Cafe", "A dessert cafe with a variety of different drinks and specialise in honey bread, croffles and bingsu", "Northbridge", R.drawable.camellia_cafe),
            Cafe("Tiara Cafe", "A cute cafe hidden in Northbridge that specialises in honey bread, croffles, cakes and bingsu", "Northbridge", R.drawable.tiara_cafe),
            Cafe("20Twenty", "A cafe that specialises in all things cake and coffee!", "Northbridge", R.drawable.twentytwenty),
            Cafe("Brown Spoon", "Perth's FIRST Korean dessert cafe has everything from pancakes and bagels to bingsu and honey toast bread.", "Victoria Park", R.drawable.brown_spoon),
            Cafe("Matcha Garden", "A perfect spot for matcha lovers!", "Victoria Park", R.drawable.matcha_garden),
            Cafe("Cafe Eighty2", "A Korean fusion cafe that serves lunch options alongside breakfast and dessert ", "Victoria Park", R.drawable.cafe_eighty2),
            Cafe("Hinata Cafe", "An authentic Japanese cafe that offers traditional home-style cooking, with seasonal menus ", "Fremantle", R.drawable.hinata_cafe),
            Cafe("Moore & Moore", "A charming cafe in an old merchant's warehouse that not only is a cafe but a popular event venue!", "Fremantle", R.drawable.moore_and_moore),
            Cafe("Cheol's Cafe", "A cozy, friendly cafe that reimagines the breakfast scene with Asian fusions", "Mount Lawley", R.drawable.cheols_cafe),
        )
    )
    val cafes: LiveData<List<Cafe>> get() = _cafes

    fun toggleFavourite(cafe: Cafe) {
        cafe.isFavourited = !cafe.isFavourited
        _cafes.value = _cafes.value.orEmpty()
    }
}
