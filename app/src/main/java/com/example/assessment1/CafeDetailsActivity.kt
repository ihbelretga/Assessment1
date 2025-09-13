package com.example.assessment1

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import kotlin.getValue

class CafeDetailsActivity: AppCompatActivity() {
    private val vm: CafesViewModel by viewModels()
    private lateinit var detailFavouriteBtn: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe_details)

        val cafe = intent.getParcelableExtra<Cafe>("cafe")
        if (cafe == null) {
            finish()
            return
        }

        val detailImage : ImageView = findViewById(R.id.detailImage)
        val detailTitle : TextView = findViewById(R.id.detailTitle)
        val detailCategory : TextView = findViewById(R.id.detailCategory)
        val detailDescription : TextView = findViewById(R.id.detailDescription)
        detailFavouriteBtn = findViewById(R.id.detailFavouriteBtn)

        detailImage.setImageResource(cafe.imageID)
        detailTitle.text = cafe.title
        detailCategory.text = cafe.category
        detailDescription.text = cafe.description
        detailFavouriteBtn.setImageResource(
            if (cafe.isFavourited) R.drawable.filled_heart else R.drawable.empty_heart
        )

        detailFavouriteBtn.setOnClickListener {
            vm.toggleFavourite(cafe)

            detailFavouriteBtn.setImageResource(
                if (cafe.isFavourited) R.drawable.filled_heart else R.drawable.empty_heart
            )

            if (cafe.isFavourited) {
                Toast.makeText(this, "${cafe.title} added to favourites", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "${cafe.title} removed from favourites", Toast.LENGTH_SHORT).show()
            }

        }

    }
}