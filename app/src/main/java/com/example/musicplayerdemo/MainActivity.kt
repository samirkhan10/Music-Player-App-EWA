package com.example.musicplayerdemo

import android.media.AudioManager
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

   lateinit var startBtn : Button
  lateinit  var stopBtn : Button
  lateinit var mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn = findViewById(R.id.startBtn)
        stopBtn = findViewById(R.id.stopBtn)
        mediaPlayer = MediaPlayer()

        startBtn.setOnClickListener {

            var songUrl = "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"

             mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
            try {

                mediaPlayer.setDataSource(songUrl)
                mediaPlayer.prepare()
                mediaPlayer.start()

            }catch (e:Exception){

                e.printStackTrace()
            }
            Toast.makeText(this,"Audio is playing...",Toast.LENGTH_LONG).show()

        }
        stopBtn.setOnClickListener {

            if (mediaPlayer.isPlaying){
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()

                Toast.makeText(this,"Audio is stoping...",Toast.LENGTH_LONG).show()

            }else {
                Toast.makeText(this,"Audio is not playing...",Toast.LENGTH_LONG).show()
            }

        }


    }
}