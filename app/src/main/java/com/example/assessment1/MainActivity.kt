package com.example.assessment1

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessment1.CafeAdapter

import com.example.assessment1.CafesViewModel
import kotlin.getValue

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cafeList = listOf(
            Cafe("Example cafe title", "Some kinda description", "Northbridge", android.R.color.darker_gray),
            Cafe("Example cafe 2 title", "Some kinda description", "Fremantle", android.R.color.darker_gray)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = CafeAdapter(cafeList, this)
    }
}