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
        val signupbtnsignuppage = findViewById<Button>(R.id.signupbtnsignuppage)

        //handle button click
        signupbtnsignuppage.setOnClickListener {
            //Get texts from text edittexts
           val username = usernamesignupfield.text.toString()
           val password = passwordsignupfield.text.toString()

            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra("usernamesignupfield", username)
                putExtra("passwordsignupupfield", password)
            })
            //intent to start activity
            //var intent = Intent(thisMainActivity, Sign_up_page::class.java)
            //intent.putExtra("usernamesignupfield", username)
            //intent.putExtra("passwordsignupupfield", password)
            //startActivity(intent)
        }
    }
}
