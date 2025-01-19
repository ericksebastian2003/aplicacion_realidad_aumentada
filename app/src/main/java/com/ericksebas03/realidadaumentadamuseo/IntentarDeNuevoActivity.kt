package com.ericksebas03.realidadaumentadamuseo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza1Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza2Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza3Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza4Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza5Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza6Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza7Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza8Activity
import com.ericksebas03.realidadaumentadamuseo.AdivinanzaState


class IntentarDeNuevoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intenta_de_nuevo)

        val btnIntentar = findViewById<Button>(R.id.btn_intentar)
        val nombreActividad = intent.getStringExtra("NOMBRE_ACTIVITY")

        btnIntentar.setOnClickListener {
            try {
                val claseActividad = Class.forName("com.ericksebas03.realidadaumentadamuseo.adivinanzas.$nombreActividad")
                val intent = Intent(this, claseActividad)
                startActivity(intent)
            } catch (e: ClassNotFoundException) {
                // Manejar el error si la actividad no existe
                e.printStackTrace()
                finish() // Salir de la actividad
            }
        }
    }
}
