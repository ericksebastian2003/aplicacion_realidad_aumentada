package com.ericksebas03.realidadaumentadamuseo

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Referencias a los elementos de la vista
        val etName: EditText = findViewById(R.id.et_name)
        val btnContinue: Button = findViewById(R.id.btn_continue)

        // Manejo del evento del botón "Continuar"
        btnContinue.setOnClickListener {
            val name = etName.text.toString().trim()

            if (name.isEmpty()) {
                // Mensaje de advertencia si no se ingresa un nombre
                Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
            } else {
                // Mensaje de bienvenida al usuario
                Toast.makeText(this, "¡Bienvenido/a, $name!", Toast.LENGTH_SHORT).show()

                // Aquí rediriges a la actividad de adivinanza
                val intent = Intent(this, com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza7Activity::class.java)
                intent.putExtra("USER_NAME", name) // Pasar el nombre del usuario si es necesario
                startActivity(intent)

            }
        }
    }
}

