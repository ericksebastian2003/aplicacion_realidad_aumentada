package com.example.splashscreen

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logoImage: ImageView = findViewById(R.id.logoImage)
        val messageText: TextView = findViewById(R.id.messageText)
        val startButton: Button = findViewById(R.id.startButton)

        // Cambiar imagen y texto dinámicamente
        logoImage.setImageResource(R.drawable.logo_app)
        messageText.text = "Esperamos que te diviertas y descubras nuevos e interesantes datos que puedas contar a tus amigos"

        startButton.setOnClickListener {
            Toast.makeText(this, "Esto debe llevar a la pantalla de inicio", Toast.LENGTH_SHORT).show()
        }
    }
}
