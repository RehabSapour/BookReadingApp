package com.example.my_app2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.imageview.ShapeableImageView
import detail_adapter

 val favoriteBooks: ArrayList<Book> = ArrayList()

class DetailActivity : AppCompatActivity() {
    lateinit var back : ImageView
    lateinit var recycler :RecyclerView
    var item: ArrayList<inter_item> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val img : ShapeableImageView = findViewById(R.id.posternrmalimg)
        val title : TextView = findViewById(R.id.booknametxt)
        val star : TextView =  findViewById(R.id.star)
        val viewer : TextView =  findViewById(R.id.viewer)
        val date : TextView =  findViewById(R.id.calender)
        val summaryinfo : TextView = findViewById(R.id.Booksummaryinfo)
        val wname : TextView = findViewById(R.id.writer)
        val writerInfo :TextView = findViewById(R.id.bookwriterinfo)

        val Bundle : Bundle ? = intent.extras
        val imag=Bundle!!.getInt("img")

        img.setImageResource(imag)
        title.text= Bundle.getString("title")
        star.text= Bundle.getString("star")
        viewer.text= Bundle.getString("views")
        date.text=Bundle.getString("date")
        summaryinfo.text= Bundle.getString("desw")
        wname.text= Bundle.getString("weitername")
        writerInfo.text= Bundle.getString("desb")

        back = findViewById(R.id.back_arrow)
        back.setOnClickListener{
            startActivity(Intent(this  , search_Activity::class.java))
        }

        val favImageView: ImageView = findViewById(R.id.fav)

        favImageView.setOnClickListener {
            val bookTitle = findViewById<TextView>(R.id.booknametxt).text.toString()
            val bookImageView = findViewById<ImageView>(R.id.posternrmalimg)
            val bookDrawable = bookImageView.drawable
            favImageView.setImageResource(R.drawable.yellow_heart)
            Toast.makeText(applicationContext, "Book added to favorites", Toast.LENGTH_SHORT).show()
            // take title and book img
            val book = Book(bookDrawable,bookTitle )
            favoriteBooks.add(book)
         }

        setData()

        //////////////////////// add recycler view code ///////////////////////////

        recycler = findViewById(R.id.recyclerView_in_detail)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapt = detail_adapter(item)
        recycler.adapter = adapt
    }


    private fun setData(){
        val images = arrayOf(
            R.drawable.mark_twien
        )
        for (i in images.indices) {
            val ob = inter_item(images[i])
            item.add(ob)
        }
    }
}
