package com.ericksebas03.realidadaumentadamuseo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class SolicitarNombreActivity : AppCompatActivity() {

    // Instancia de Firestore
    private val firestore by lazy { FirebaseFirestore.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nombre)

        // Referencias a los elementos de la vista
        val etName: EditText = findViewById(R.id.nombreusuario)
        val btnContinue: Button = findViewById(R.id.btn_continue)

        // Manejo del evento del botón "Continuar"
        btnContinue.setOnClickListener {
            val userName = etName.text.toString().trim()

            if (userName.isEmpty()) {
                // Mensaje de advertencia si no se ingresa un nombre
                Toast.makeText(this, "Por favor ingrese su nombre", Toast.LENGTH_SHORT).show()
            } else {
                // Guardar el nombre del usuario en Firestore
                saveUserToFirestore(userName)

                // Mensaje de bienvenida al usuario
                Toast.makeText(this, "¡Bienvenido/a, $userName!", Toast.LENGTH_SHORT).show()

                // Redirigir a la siguiente pantalla
                val intent = Intent(this, InicioActivity::class.java)
                intent.putExtra("USER_NAME", userName) // Pasar el nombre al siguiente Activity
                startActivity(intent)
            }
        }
    }

    private fun saveUserToFirestore(userName: String) {
        // Crear un documento con los datos del usuario
        val userData = mapOf(
            "name" to userName,
            "score" to 0 // Inicializar puntaje en 0
        )

        // Guardar en la colección "users"
        firestore.collection("users")
            .document(userName) // Usar el nombre del usuario como ID del documento
            .set(userData)
            .addOnSuccessListener {
                // Datos guardados con éxito
                println("Usuario guardado correctamente en Firestore.")
            }
            .addOnFailureListener { e ->
                // Error al guardar los datos
                println("Error al guardar el usuario: ${e.message}")
            }
    }
}
