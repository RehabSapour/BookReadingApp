package com.example.my_app2

import android.view.LayoutInflater
import android.graphics.Color
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.ViewGroup
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.my_app2.ItemModel
import com.example.my_app2.ItemModel2
import com.example.my_app2.R
import java.util.logging.Filter

class favAdapter (private val favoriteBooks: List<Book>) : RecyclerView.Adapter<favAdapter.BookViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = favoriteBooks[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return favoriteBooks.size
    }

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookImageView: ImageView = itemView.findViewById(R.id.pic1)
        private val bookTitleTextView: TextView = itemView.findViewById(R.id.titletxt2)

        fun bind(book: Book) {
            bookImageView.setImageResource(book.imageId)
            bookTitleTextView.text = book.title
        }
    }
}