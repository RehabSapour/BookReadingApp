package com.example.my_app2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class favBooks : AppCompatActivity() {
    private lateinit var favoriteBooks: ArrayList<Book>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_books)

        favoriteBooks = intent.getSerializableExtra("favoriteBooks") as ArrayList<Book>

        val recyclerView: RecyclerView = findViewById(R.id.fav_books)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = favAdapter(favoriteBooks)
        recyclerView.adapter = adapter

    }
}