package com.example.caravan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Host_screen : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()
    val TAG = "DocumentCreation"
    val user = FirebaseAuth.getInstance().currentUser
    val keys = arrayListOf<String>()
    var documentId:String = ""

    val lobby = hashMapOf(
        "users" to keys,
        "skipcounter" to 0
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.host_screen)
        val lobbyCode = findViewById<TextView>(R.id.lobbycode)

        if(user !=null){
            keys.add(user.uid)
            lobby.put("users", keys)


            var newLobby = db.collection("lobbies").document()

            documentId = newLobby.id

            newLobby.set(lobby)
                .addOnSuccessListener {
                    Log.d(TAG, "DocumentSnapshot successfully written!")
                    lobbyCode.text = documentId
                }
                .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }




        } else {
            lobbyCode.text = "FAILED"
        }
    }
}
