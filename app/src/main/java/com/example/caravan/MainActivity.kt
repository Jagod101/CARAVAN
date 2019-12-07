package com.example.caravan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.loginin_screen.*

class MainActivity : AppCompatActivity() {

    //check for user
    private fun getUserName() = intent.extras?.get("username").toString().trim()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginin_screen)

        signupbtntosignuppage.setOnClickListener{
            val intent = Intent(this, Sign_up_page::class.java)
            startActivity(intent)
        }
        loginbtn.setOnClickListener{
            val intent = Intent(this, Choice_Screen::class.java)
            startActivity(intent)
        }
    }
}
