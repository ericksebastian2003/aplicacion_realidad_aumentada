package com.ericksebas03.realidadaumentadamuseo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.content.Intent
import com.ericksebas03.realidadaumentadamuseo.splashscreen.SplashActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnContinuar = findViewById<Button>(R.id.continue_button)

        btnContinuar.setOnClickListener{
            // Crear un Intent para iniciar SplashActivity
            val intent = Intent(this,SplashActivity::class.java)
            // Iniciar SplashActivity
            startActivity(intent)

        }

    }
}