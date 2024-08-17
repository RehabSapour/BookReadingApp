package com.example.my_app2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {
    lateinit var sign : AppCompatButton
    lateinit var  signtext : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        sign=findViewById(R.id.login_btn)
        signtext=findViewById(R.id.signup_in_login)

        signtext.setOnClickListener{
            startActivity(Intent(this, signup::class.java))
        }

        sign.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        val emailEditText: TextInputEditText = findViewById(R.id.email_in_login)
        val passwordEditText: TextInputEditText = findViewById(R.id.pass_EditText)

        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        if (email.isEmpty()) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
        }
       else if (email.length > 24) {
            Toast.makeText(this, "Email should not exceed 24 characters", Toast.LENGTH_SHORT).show()
        }
       else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show()
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
        }
        else if (password.length > 8) {
            Toast.makeText(this, "Password must be at most 8 characters long", Toast.LENGTH_SHORT).show()
        }

       else if (email.isNotEmpty() && password.isNotEmpty() && email.length <= 24 && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length <= 8) {
            startActivity(Intent(this, search_Activity::class.java))
            Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show()
        }
    }
}