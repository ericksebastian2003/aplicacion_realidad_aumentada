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


class IntentarDeNuevoActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intenta_de_nuevo)
        val btnIntentar = findViewById<Button>(R.id.btn_intentar)
        val nombreActividad = intent.getStringExtra("NOMBRE_ACTIVITY")
        btnIntentar.setOnClickListener {
            //La condicional para saber a donde volver
            when (nombreActividad) {
                "Adivinanza1Activity" -> {
                    val actividad = Intent(this, Adivinanza1Activity::class.java)
                    startActivity(actividad)
                }

                "Adivinanza2Activity" -> {
                    val actividad = Intent(this, Adivinanza2Activity::class.java)
                    startActivity(actividad)
                }

                "Adivinanza3Activity" -> {
                    val actividad = Intent(this, Adivinanza3Activity::class.java)
                    startActivity(actividad)

                }

                "Adivinanza4Activity" -> {
                    val actividad = Intent(this, Adivinanza4Activity::class.java)
                    startActivity(actividad)

                }
                "Adivinanza5Activity" -> {
                    val actividad = Intent(this, Adivinanza5Activity::class.java)
                    startActivity(actividad)
                }
                "Adivinanza6Activity" -> {
                    val actividad = Intent(this, Adivinanza6Activity::class.java)
                    startActivity(actividad)

                }
                "Adivinanza7Activity" -> {
                    val actividad = Intent(this, Adivinanza7Activity::class.java)
                    startActivity(actividad)

                }
                "Adivinanza8Activity" -> {
                    val actividad = Intent(this, Adivinanza8Activity::class.java)
                    startActivity(actividad)

                }

            }


        }

    }
}