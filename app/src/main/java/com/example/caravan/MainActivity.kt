package com.example.caravan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;

import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;
import kotlinx.android.synthetic.main.loginin_screen.*

class MainActivity : AppCompatActivity() {

    //check for user
    //private fun getUserName() = intent.extras?.get("username").toString().trim()
//    companion object {
//        val CLIENT_ID: String = "0ac0be38dfa24683a2f3150bbbe4811e"
//        val REDIRECT_URI : String = "com.example.caravan://callback"
//    }


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
        spotifyLink.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java)
            startActivity(intent)
        }
    }
}
