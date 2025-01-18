package com.ericksebas03.realidadaumentadamuseo.adivinanzas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.CameraActivity
import com.ericksebas03.realidadaumentadamuseo.R

class Adivinanza1Activity : AppCompatActivity() {
    //Guardar en la variable nombreActivity el nombre de la actividad
    val nombreActivity = Adivinanza1Activity::class.java.name
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_adivinanza_1)

        val btnContinuar = findViewById<Button>(R.id.btn_intentar)

        btnContinuar.setOnClickListener(){

            val intent = Intent(this, CameraActivity::class.java)
            //Enviar parametros
            intent.putExtra("ACTIVITY", nombreActivity)
            startActivity(intent)

        }

    }
}