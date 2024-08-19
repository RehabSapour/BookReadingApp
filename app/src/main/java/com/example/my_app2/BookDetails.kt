package com.example.my_app2
import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import java.io.Serializable

data class ItemModel2(
    val img: Int,
    val booktitle: String,
    val stars: String,
    val views: String,
    val date:String,
    val summaryinfo:String,
    val writerName:String,
    val Writerinfo:String
)
