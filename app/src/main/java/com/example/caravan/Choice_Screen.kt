package com.example.caravan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.choice__screen.*

class Choice_Screen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choice__screen)

        hostbtn.setOnClickListener {
            val intent = Intent(this, Host_screen::class.java)
            startActivity(intent)
        }

        joinbtn.setOnClickListener {
            val intent = Intent(this, Join_screen::class.java)
            startActivity(intent)
        }
    }
}
