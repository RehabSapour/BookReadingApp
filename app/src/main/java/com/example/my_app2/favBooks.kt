package com.example.my_app2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class favBooks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_books)

        val recyclerView: RecyclerView = findViewById(R.id.fav_books)
        recyclerView.layoutManager = GridLayoutManager(this,3)
        val adapter = favAdapter()
        recyclerView.adapter = adapter
    }
}