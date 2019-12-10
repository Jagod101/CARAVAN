package com.example.caravan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import android.widget.Button
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_player.*


class PlayerActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener {
    private var counter: Int = 1
    var VIDEO_ID: String = "oHg5SJYRHA0";

    override fun onInitializationSuccess(provider: YouTubePlayer.Provider?, player: YouTubePlayer?, wasRestored: Boolean) {
        Toast.makeText(applicationContext, "Youtube Api Initialization Success", Toast.LENGTH_SHORT).show()
        if (!wasRestored) {
            player?.cueVideo(VIDEO_ID);
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        Toast.makeText(applicationContext, "Youtube Api Initialization Failure", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
        ytPlayer.initialize("AIzaSyCqLV1oktUjpW3fqKU95jQwxRXwCv62K0Q", this)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_player)

        randomBtn.setOnClickListener {
            if (counter == 1) {
                VIDEO_ID = "oHg5SJYRHA0"; counter++
            }
            if (counter == 2) {
                VIDEO_ID = "CnQ4WDSlDfg"; counter++
            }
            if (counter == 3) {
                VIDEO_ID = "ahZFCF--uRY"; counter++
            }
        }
    }
}
