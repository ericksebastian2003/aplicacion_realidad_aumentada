package com.ericksebas03.realidadaumentadamuseo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.SeccionesActivity

class InicioActivity: AppCompatActivity() {

    private lateinit var tituloApp: TextView
    private lateinit var imagenPrincipal: ImageView
    private lateinit var descripcion: TextView
    private lateinit var btnSigPag: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        // Inicializar las vistas
        tituloApp = findViewById(R.id.tituloApp)
        //imagenPrincipal = findViewById(R.id.imagenPrincipal)
        //descripcion = findViewById(R.id.descripcion)

        btnSigPag = findViewById(R.id.continue_button)

        // Obtener el nombre del Intent
        val userName = intent.getStringExtra("USER_NAME")

        // Mostrar el nombre si se ha recibido
        if (!userName.isNullOrEmpty()) {
            tituloApp.text = "Hola, $userName"
        } else {
            tituloApp.text = "Hola, Usuario"
        }

        // Acción del botón "Siguiente"
        btnSigPag.setOnClickListener {
            val intent = Intent(this, SeccionesActivity::class.java)
            startActivity(intent)
        }
    }
}
