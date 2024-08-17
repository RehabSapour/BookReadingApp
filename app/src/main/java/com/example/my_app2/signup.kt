package com.example.my_app2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class signup : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        val login_text = findViewById<TextView>(R.id.login_at_sign)
        login_text.setOnClickListener{
            startActivity(Intent(this , Login::class.java))
        }

        val signUpButton: AppCompatButton = findViewById(R.id.signup_btn)
        signUpButton.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {
        val usernameEditText: TextInputEditText = findViewById(R.id.fullname)
        val emailEditText: TextInputEditText = findViewById(R.id.email)
        val passwordEditText: TextInputEditText = findViewById(R.id.password)

        val username = usernameEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()
        val email = emailEditText.text.toString().trim()

        if (username.isEmpty()) {
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show()
        }
       else if (email.isEmpty()) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
        } else if (email.length > 24) {
            Toast.makeText(this, "Email should not exceed 24 characters", Toast.LENGTH_SHORT).show()
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show()
        }

        else if (password.isEmpty()) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
        }else if (password.length > 8) {
            Toast.makeText(this, "Password must be at most 8 characters long", Toast.LENGTH_SHORT).show()
        }

        else if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()&& email.length <= 24 && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length <= 8) {
            startActivity(Intent(this, search_Activity::class.java))
            Toast.makeText(this, "sign up successfully", Toast.LENGTH_SHORT).show()
        }
    }

}