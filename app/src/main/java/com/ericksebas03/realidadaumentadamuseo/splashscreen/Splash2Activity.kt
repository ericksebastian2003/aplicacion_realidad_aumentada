package com.ericksebas03.realidadaumentadamuseo.splashscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.R
import com.ericksebas03.realidadaumentadamuseo.SolicitarNombreActivity

class Splash2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        // Buscar el botón en el layout
        val botonContinuar = findViewById<Button>(R.id.bottonsplash2)

        // Configurar el click del botón
        botonContinuar.setOnClickListener {
            // Crear un Intent para iniciar el screen
            val intent = Intent(this, SolicitarNombreActivity::class.java)
            // Iniciar
            startActivity(intent)
        }
    }
}
