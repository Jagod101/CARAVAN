package com.example.caravan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.loginin_screen.*
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.loginin_screen.signupbtntosignuppage
import kotlinx.android.synthetic.main.sign_up_screen.*
import com.google.firebase.auth.FirebaseUser

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import androidx.annotation.NonNull
import com.google.android.gms.tasks.OnCompleteListener
import android.R.attr.password
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T






class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    //check for user
    //private fun getUserName() = intent.extras?.get("username").toString().trim()
//    companion object {
//        val CLIENT_ID: String = "0ac0be38dfa24683a2f3150bbbe4811e"
//        val REDIRECT_URI : String = "com.example.caravan://callback"
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.loginin_screen)

        val email = findViewById<TextView>(R.id.emailfield)
        val password = findViewById<TextView>(R.id.passwordText)
        signupbtntosignuppage.setOnClickListener{
            val intent = Intent(this, Sign_up_page::class.java)
            startActivity(intent)
        }
        loginbtn.setOnClickListener{
            sigInWithEmail(email.text.toString().trim(), password.text.toString().trim())


        }


    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.getCurrentUser()

    }

    private val TAG = "Authentication"
    private fun sigInWithEmail(email:String, password:String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this,
                OnCompleteListener<AuthResult> { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithEmail:success")

                        val intent = Intent(this, Choice_Screen::class.java)
                        startActivity(intent)

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()

                    }

                })

    }
    private fun signInAnonymously() {

        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInAnonymously:success")

                } else {
                    Log.w(TAG, "signInAnonymously:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }

            }
    }
}
