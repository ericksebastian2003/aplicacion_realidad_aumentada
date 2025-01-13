package com.ericksebas03.realidadaumentadamuseo

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SolicitarNombreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nombre)
        // Referencias a los elementos de la vista
        val etName: EditText = findViewById(R.id.nombreusuario)
        val btnContinue: Button = findViewById(R.id.btn_continue)

        // Manejo del evento del botón "Continuar"
        btnContinue.setOnClickListener {
            val name_user= etName.text.toString().trim()
            if (name_user.isEmpty()) {
                // Mensaje de advertencia si no se ingresa un nombre
                Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
            } else {
                // Mensaje de bienvenida al usuario
                Toast.makeText(this, "¡Bienvenido/a, $name_user!", Toast.LENGTH_SHORT).show()
                // Redirigir
                val intent = Intent(this, InicioActivity::class.java)
                intent.putExtra("USER_NAME", name_user) // Pasar datos si es necesario
                startActivity(intent)

            }
        }
    }
}
