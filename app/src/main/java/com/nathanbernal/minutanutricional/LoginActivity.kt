package com.nathanbernal.minutanutricional

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val mp = MediaPlayer.create(this, R.raw.riser_intro)
        val btn = findViewById<Button>(R.id.btnIniciar)

        btn.setOnClickListener {
            mp.start()
            startActivity(Intent(this, HomeActivity::class.java))
        }

    }

}