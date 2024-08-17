package com.example.my_app2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.imageview.ShapeableImageView
import detail_adapter

class DetailActivity : AppCompatActivity() {
    lateinit var back : ImageView
    lateinit var recycler :RecyclerView
    var item: ArrayList<inter_item> = ArrayList()
   //public val favoriteBooks: ArrayList<Book> = ArrayList()
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
        val tit1 = Bundle.getString("title")
        val sta = Bundle.getString("star")
        val views = Bundle.getString("views")
        val cal = Bundle.getString("date")
        val writerinfo = Bundle.getString("desb")
        val name = Bundle.getString("weitername")
        val  bookinfo = Bundle.getString("desw")

//        val des = getString(R.string.first)
//        val info = getString(R.string.des1)

        img.setImageResource(imag)
        title.text=tit1
        star.text=sta
        viewer.text=views
        date.text=cal
        summaryinfo.text=bookinfo
        wname.text=name
        writerInfo.text= writerinfo


        back = findViewById(R.id.back_arrow)
        back.setOnClickListener{
            startActivity(Intent(this  , search_Activity::class.java))
        }

        val favImageView: ImageView = findViewById(R.id.fav)


        favImageView.setOnClickListener {
           // val book = Book(imag, tit)
          //  favoriteBooks.add(book)
            favImageView.setImageResource(R.drawable.yellow_heart)
            Toast.makeText(applicationContext, "Book added to favorites", Toast.LENGTH_SHORT).show()

        }

        val images = arrayOf(
            R.drawable.mark_twien
//            R.drawable.one, R.drawable.two, R.drawable.three,
//            R.drawable.one, R.drawable.two, R.drawable.three,
//            R.drawable.one, R.drawable.two, R.drawable.three,

        )
        for (i in images.indices) {
            val ob = inter_item(images[i])
            item.add(ob)
        }

        recycler = findViewById(R.id.recyclerView_in_detail)
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val adapt = detail_adapter(item)
        recycler.adapter = adapt
    }
}
