package com.ericksebas03.realidadaumentadamuseo.adivinanzas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.R

class Adivinanza7Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivinanza_7)

        // Obtener la referencia del Button
        val btnLectorQR: Button = findViewById(R.id.btnLectorQR)

        // Configurar el OnClickListener para abrir el lector de QR
        btnLectorQR.setOnClickListener {
            // Redirigir a la actividad LectorQRActivity (usando ZXing o tu lector preferido)
            val intent = Intent(this, com.ericksebas03.realidadaumentadamuseo.lectorqr.LectorQR ::class.java) // ZXing CaptureActivity
            startActivity(intent)
        }
    }
}
