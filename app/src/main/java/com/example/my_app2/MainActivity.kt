package com.example.my_app2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class MainActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var gotit=findViewById<AppCompatButton>(R.id.git_in_btn)
        gotit.setOnClickListener{
            startActivity(Intent(this , Login::class.java))
        }

    }

}


