package com.example.caravan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
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
        spotifyLink.setOnClickListener{
            //val intent = Intent.ACTION_VIEW, Uri.parse("https://accounts.spotify.com/en/login?continue=https:%2F%2Fopen.spotify.com%2Fartist%2F7mz6tB1Og2yzxP74wxDVrn\"")
            //startActivity(intent)
       }

    }
}
