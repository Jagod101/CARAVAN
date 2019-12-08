package com.example.caravan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.loginin_screen.*
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    //check for user
    //private fun getUserName() = intent.extras?.get("username").toString().trim()

    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginin_screen)

        signupbtntosignuppage.setOnClickListener{
            val intent = Intent(this, Sign_up_page::class.java)
            startActivity(intent)
        }
        loginbtn.setOnClickListener{
            val intent = Intent(this, Choice_Screen::class.java)
            startActivity(intent)
            signInAnonymously();
        }

//        spotifyLink.setOnClickListener{
            //val intent = Intent.ACTION_VIEW, Uri.parse("https://accounts.spotify.com/en/login?continue=https:%2F%2Fopen.spotify.com%2Fartist%2F7mz6tB1Og2yzxP74wxDVrn\"")
            //startActivity(intent)
      // }

    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser

    }

    private val TAG = "Authentication"
    private fun signInAnonymously() {

        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInAnonymously:success")
                    val user = auth.currentUser
                } else {
                    Log.w(TAG, "signInAnonymously:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

            }
    }
}
