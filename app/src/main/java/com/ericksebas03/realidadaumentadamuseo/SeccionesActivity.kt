package com.ericksebas03.realidadaumentadamuseo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza5Activity
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza1Activity
//import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza7Activity

import android.view.View


class SeccionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_secciones)

            // Variables
            val section1 = findViewById<View>(R.id.card1)
            val section2 = findViewById<View>(R.id.card2)
            val section3 = findViewById<View>(R.id.card3)
            val section4 = findViewById<View>(R.id.card4)

            section1.setOnClickListener {
                val intent = Intent(
                    this@SeccionesActivity,
                    Adivinanza5Activity::class.java
                )
                startActivity(intent)
            }

            section2.setOnClickListener {
                val intent = Intent(
                    this@SeccionesActivity,
                    Adivinanza1Activity::class.java
                )
                startActivity(intent)
            }

            section3.setOnClickListener {
                val intent = Intent(
                    this@SeccionesActivity,
                    Adivinanza5Activity::class.java
                )
                startActivity(intent)
            }

            section4.setOnClickListener {
                // Intent intent = new Intent(SeccionesActivity.this, Adivinanza7Activity.class);
                // startActivity(intent);
            }


    }
}