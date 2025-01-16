package com.ericksebas03.realidadaumentadamuseo.splashscreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.R
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza1Activity

class Splash2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        val botonContinuar = findViewById<Button>(R.id.btn_continuar)
        botonContinuar.setOnClickListener {
            // Redirigir a la actividad LectorQRActivity (usando ZXing o tu lector preferido)
            val intent = Intent(this, com.ericksebas03.realidadaumentadamuseo.Home ::class.java) // ZXing CaptureActivity
            startActivity(intent)
        }


    }
}
