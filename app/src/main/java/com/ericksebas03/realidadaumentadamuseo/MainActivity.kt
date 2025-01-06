package com.ericksebas03.realidadaumentadamuseo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.splashscreen.Splash2Activity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrA = findViewById<Button>(R.id.btn_acceder) // Verifica que btn_acceder existe en el XML

        btnIrA.setOnClickListener {
            // Crear un Intent para iniciar Splash2Activity
            val intent = Intent(this, Splash2Activity::class.java)
            // Iniciar Splash2Activity
            startActivity(intent)
        }
    }
}
