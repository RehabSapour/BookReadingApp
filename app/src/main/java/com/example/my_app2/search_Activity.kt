package com.example.my_app2

import MyAdapter
import MyAdapter2
import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView

class search_Activity : AppCompatActivity() {
  lateinit var  recyclerView: RecyclerView
  lateinit var recyclerView2: RecyclerView
    private lateinit var titles :Array<String>
    private lateinit var titles2 :Array<String>
    private lateinit var newArraylist :ArrayList< ItemModel2>
    private lateinit var list2 :ArrayList< ItemModel2>
    private lateinit var items :List< ItemModel>
    private lateinit var items2 :List< ItemModel>
    private lateinit var images :Array<Int>
    private lateinit var images2 :Array<Int>
    private lateinit var WriterNames :Array<String>
    private lateinit var  descw :Array<String>
    private lateinit var desb :Array<Int>
   private lateinit var search : EditText
   private lateinit var home: ImageView
   private lateinit var person: ImageView
    private lateinit var  test :Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val progressBar1 = findViewById<ProgressBar>(R.id.progressBar1)
        progressBar1.visibility = View.VISIBLE
        val progressBar2 = findViewById<ProgressBar>(R.id.progressBar2)
        progressBar2.visibility = View.VISIBLE

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({

            progressBar1.visibility = View.GONE
            progressBar2.visibility = View.GONE
        }, 2000)

     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           items = listOf(
            ItemModel(R.drawable.one, "Huckleberry Finn", "4.5 votes",),
            ItemModel(R.drawable.two, "Pirate Queen", "3.8 votes"),
            ItemModel(R.drawable.three, "Huckleberry Finn", "4.2 votes"),
            ItemModel(R.drawable.one, "elsera_elnabawya", "4.5 votes"),
            ItemModel(R.drawable.two, "Huckleberry Finn", "3.8 votes"),
            ItemModel(R.drawable.three, "Huckleberry Finn", "4.2 votes"),
            ItemModel(R.drawable.one, "Huckleberry Finn", "4.5 votes"),
            ItemModel(R.drawable.two, "Huckleberry Finn", "3.8 votes"),
            ItemModel(R.drawable.three, "Huckleberry Finn", "4.2 votes")
        )

        items2 = listOf(
            ItemModel(R.drawable.book1, "Cave crawlers ", "4.9 votes",),
            ItemModel(R.drawable.book2, "Furry Farm ", "3.8 votes"),
            ItemModel(R.drawable.book3, "Alexander ", "3.7 votes"),
            ItemModel(R.drawable.book4, "The Wager", "4.6 votes"),
            ItemModel(R.drawable.book1, "Cave crawlers", "3.8 votes"),
            ItemModel(R.drawable.book2, "Furry Farm", "3.2 votes"),
            ItemModel(R.drawable.book3, "Alexander", "3.5 votes"),
            ItemModel(R.drawable.book4, "The Wager", "3.8 votes"),
            ItemModel(R.drawable.book1, "Cave crawlers", "4.2 votes")
        )

        setArrays()
        setdata()

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter =MyAdapter(items)
        recyclerView.adapter =adapter
        adapter.onItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@search_Activity , DetailActivity::class.java)
                intent.putExtra("img" , newArraylist[position].img)
                intent.putExtra("title" , newArraylist[position].booktitle)
                intent.putExtra("star" , newArraylist[position].stars)
                intent.putExtra("views" , newArraylist[position].views)
                intent.putExtra("date" , newArraylist[position].date)
                intent.putExtra("desb" , newArraylist[position].summaryinfo)
                intent.putExtra("weitername" , newArraylist[position].writerName)
                intent.putExtra("desw" , newArraylist[position].Writerinfo)
                startActivity(intent)

            }
        })


        recyclerView2 = findViewById(R.id.recyclerView2)
        recyclerView2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter2 = MyAdapter2(items2)
        recyclerView2.adapter = adapter2

        adapter2.onItemClickListener(object : MyAdapter2.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@search_Activity , DetailActivity::class.java)
                intent.putExtra("img" , list2[position].img)
                intent.putExtra("title" , list2[position].booktitle)
                intent.putExtra("star" , list2[position].stars)
                intent.putExtra("views" , list2[position].views)
                intent.putExtra("date" , list2[position].date)
                intent.putExtra("desb" , list2[position].summaryinfo)
                intent.putExtra("weitername" , list2[position].writerName)
                intent.putExtra("desw" , list2[position].Writerinfo)
                startActivity(intent)
            }
        })


        visible()

        home=findViewById(R.id.compass)
        home.setOnClickListener{
            startActivity(Intent(this , MainActivity::class.java))
        }
        person=findViewById(R.id.person)
        person.setOnClickListener{
            startActivity(Intent(this , Login::class.java))
        }



        // TextWatcher for search functionality
        search = findViewById(R.id.editTextText)
        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
                adapter2.filter(s.toString())
            }
        })
    }


     private fun setArrays(){
         // Assuming you have a list of data items

         WriterNames = arrayOf(
             "Mark Twain","Stephen King","Marci Peschke", "Mark Twain","Stephen King","Marci Peschke" , "Mark Twain","Stephen King","Marci Peschke"
         )
         images = arrayOf(
             R.drawable.one ,R.drawable.two,R.drawable.three,R.drawable.one ,R.drawable.two,R.drawable.three ,R.drawable.one ,R.drawable.two,R.drawable.three
         )
         images2 = arrayOf(
             R.drawable.book1 ,R.drawable.book2,R.drawable.book3,R.drawable.book4
             , R.drawable.book1 ,R.drawable.book2,R.drawable.book3,R.drawable.book4,R.drawable.book1
         )
         titles=arrayOf(
             " Huckleberry Finn" ,"The Bachman books","Pirate Queen",  " Huckleberry Finn" ,
             "The Bachman books","Pirate Queen"," Huckleberry Finn" ,"The Bachman books","Pirate Queen"
         )
         titles2= arrayOf(
             "Cave crawlers","Furry Farm","Alexander","The Wager","Cave crawlers",
             "Furry Farm","Alexander","The Wager","Cave crawlers"
         )

//         desb = arrayOf(
//                 R.string.des1 , R.string.des2 ,R.string.des3 , R.string.des1 , R.string.des2 ,R.string.des3,R.string.des1 , R.string.des2 ,R.string.des3
//
//         )

         test = arrayOf(
             getString(R.string.des1),getString(R.string.des2),getString(R.string.des3)
             ,getString(R.string.des1),getString(R.string.des2),getString(R.string.des3),
             getString(R.string.des1),getString(R.string.des2),getString(R.string.des3)
         )
         descw = arrayOf(
             getString(R.string.first),getString(R.string.second),getString(R.string.third)
             ,getString(R.string.first),getString(R.string.second),getString(R.string.third),
             getString(R.string.first),getString(R.string.second),getString(R.string.third)
         )
     }


    private fun setdata() {
        newArraylist = arrayListOf()
        for (i in images.indices) {
            val sol = ItemModel2(images[i], titles[i], "12k votes", "24k Reads", "7/1998", test[i], WriterNames[i], descw[i])
            newArraylist.add(sol)
        }

        list2 = arrayListOf()
        for (i in images2.indices) {
            val sol = ItemModel2(images2[i], titles2[i], "14k votes", "20k Reads", "7/2008", test[i], WriterNames[i], descw[i])
            list2.add(sol)
        }

    }

    private fun visible(){
        recyclerView.visibility = View.INVISIBLE
        Handler(Looper.getMainLooper()).postDelayed({

            recyclerView.visibility = View.VISIBLE
        }, 2000)

        recyclerView2.visibility = View.INVISIBLE
        Handler(Looper.getMainLooper()).postDelayed({

            recyclerView2.visibility = View.VISIBLE
        }, 2000)
    }

}