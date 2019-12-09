package com.example.caravan

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.caravan.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.sign_up_screen.*

class Sign_up_page : AppCompatActivity(){
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_screen)
        auth = FirebaseAuth.getInstance()
        //take values from the sign up screen
        val emailsignupfield = findViewById<EditText>(R.id.emailsignupfield)
        val passwordsignupfield = findViewById<EditText>(R.id.passwordsignupfield)
        val SignUpButton = findViewById<Button>(R.id.signupbtntosignuppage)
        val BackBtn = findViewById<Button>(R.id.backbtnsignuppage)
        val TAG = "User Creation: "
        //handle button click
        //sign up button
        SignUpButton.setOnClickListener {
            //Get texts from text edittexts
           val email = emailsignupfield.text.toString()
           val password = passwordsignupfield.text.toString()


            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        startActivity(Intent(this, Choice_Screen::class.java).apply {
                            putExtra("usernamesignupfield", email)
                            putExtra("passwordsignupupfield", password)
                        })

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }

                }

        }
        //back button
        BackBtn.setOnClickListener {
            //Get texts from text edittexts
            val username = emailsignupfield.text.toString()
            val password = passwordsignupfield.text.toString()

            startActivity(Intent(this, MainActivity::class.java).apply{
                putExtra("usernamesignupfield", username)
                putExtra("passwordsignupupfield", password)
            })
        }
    }
}
