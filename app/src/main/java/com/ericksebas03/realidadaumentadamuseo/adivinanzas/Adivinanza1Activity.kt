package com.ericksebas03.realidadaumentadamuseo.adivinanzas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.ericksebas03.realidadaumentadamuseo.R

class Adivinanza1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivinanza1)
        val btnEncontrar = findViewById<Button>(R.id.btn_encontrar)

        btnEncontrar.setOnClickListener{

        }

    }
}