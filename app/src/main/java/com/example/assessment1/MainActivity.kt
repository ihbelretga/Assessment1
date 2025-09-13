package com.example.assessment1

import android.graphics.Color
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView
import android.widget.EditText
import kotlin.getValue

class MainActivity : AppCompatActivity() {

    private val vm: CafesViewModel by viewModels()
    private lateinit var adapter: CafeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = CafeAdapter(mutableListOf(), vm)
        val searchView: SearchView = findViewById(R.id.searchView)

        // Access the internal EditText and set colors
        val searchEditText = searchView.findViewById<EditText>(
            androidx.appcompat.R.id.search_src_text
        )
        searchEditText.setTextColor(Color.BLACK)
        searchEditText.setHintTextColor(Color.GRAY)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

        vm.cafes.observe(this) { cafes ->
            adapter.updateList(cafes)
        }
    }
}