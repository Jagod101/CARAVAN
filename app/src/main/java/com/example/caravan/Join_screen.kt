package com.example.caravan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

import com.google.firebase.firestore.DocumentReference




class Join_screen : AppCompatActivity() {

    val db = FirebaseFirestore.getInstance()
    val TAG = "DocumentCreation"
    val user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join_screen)
        val skipBtn = findViewById<TextView>(R.id.skip)
        val lobbyCode = findViewById<EditText>(R.id.lobbycode)

        skipBtn.setOnClickListener{
            if(user!=null){
                insertVote(lobbyCode.toString());
            }

        }
    }

    private fun insertVote(lobbyCode:String){
        var docRef : DocumentReference = FirebaseFirestore.getInstance().collection("lobbies").document(lobbyCode)

        db.collection("lobbies").document(lobbyCode)


    }


}
