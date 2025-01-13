package com.ericksebas03.realidadaumentadamuseo

import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeccionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secciones)

        //Variables
        val section1 = findViewById<CardView>(R.id.card1)
        val section2 = findViewById<CardView>(R.id.card2)
        val section3 = findViewById<CardView>(R.id.card3)
        val section4 = findViewById<CardView>(R.id.card4)

    }
}