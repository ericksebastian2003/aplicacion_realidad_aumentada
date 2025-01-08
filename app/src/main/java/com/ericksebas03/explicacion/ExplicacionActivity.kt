package com.ericksebas03.explicacion

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.R

class ExplicacionActivity:AppCompatActivity() {

    private lateinit var tituloApp: TextView
    private lateinit var imagenPrincipal: ImageView
    private lateinit var descripcion: TextView
    private lateinit var btnSigPag: Button

    private val nombre: String = "A"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicacion)


        tituloApp = findViewById(R.id.tituloApp)
        imagenPrincipal = findViewById(R.id.imagenPrincipal)
        descripcion = findViewById(R.id.descripcion)
        btnSigPag = findViewById(R.id.btnSigPag)


        tituloApp.text = "Bienvenido $nombre al recorrido virtual del Museo de Historia Natural 'Gustavo Orcés V.'"


        btnSigPag.setOnClickListener {

        }
    }
}