package com.example.caravan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import com.example.caravan.R
import kotlinx.android.synthetic.main.sign_up_screen.*

class Sign_up_page : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_screen)

        //take values from the sign up screen
        val usernamesignupfield = findViewById<EditText>(R.id.usernamesignupfield)
        val passwordsignupfield = findViewById<EditText>(R.id.passwordsignupfield)
        val SignUpButton = findViewById<Button>(R.id.signupbtntosignuppage)
        val BackBtn = findViewById<Button>(R.id.backbtnsignuppage)

        //handle button click
        //sign up button
        SignUpButton.setOnClickListener {
            //Get texts from text edittexts
           val username = usernamesignupfield.text.toString()
           val password = passwordsignupfield.text.toString()

            startActivity(Intent(this, Choice_Screen::class.java).apply {
                putExtra("usernamesignupfield", username)
                putExtra("passwordsignupupfield", password)
            })
        }
        //back button
        BackBtn.setOnClickListener {
            //Get texts from text edittexts
            val username = usernamesignupfield.text.toString()
            val password = passwordsignupfield.text.toString()

            startActivity(Intent(this, MainActivity::class.java).apply{
                putExtra("usernamesignupfield", username)
                putExtra("passwordsignupupfield", password)
            })
        }
    }
}
