package com.ericksebas03.realidadaumentadamuseo

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.splashscreen.SplashActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrA = findViewById<Button>(R.id.btn_1)

        btnIrA.setOnClickListener {
            // Crear un Intent para iniciar SplashActivity
            val intent = Intent(this, SplashActivity::class.java)
            // Iniciar SplashActivity
            startActivity(intent)
        }
    }
}
