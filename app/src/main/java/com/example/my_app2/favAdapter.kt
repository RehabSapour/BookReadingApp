package com.example.my_app2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class favAdapter  : RecyclerView.Adapter<favAdapter.BookViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fav_viewholder, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = favoriteBooks[position]
        holder.bookImageView.setImageDrawable(book.imageId)
        holder.bookTitleTextView.text= book.title
    }

    override fun getItemCount(): Int {
        return favoriteBooks.size
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val bookImageView: ImageView = itemView.findViewById(R.id.pic2)
         val bookTitleTextView: TextView = itemView.findViewById(R.id.titletxt3)

    }
}