package com.ericksebas03.realidadaumentadamuseo

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIrA = findViewById<Button>(R.id.btn_1)

        btnIrA.setOnClickListener {
            // Crear un Intent para iniciar Respuesta1Activity
            val intent = Intent(this, Respuesta1Activity::class.java)
            // Iniciar Respuesta1Activity
            startActivity(intent)
        }
    }
}
