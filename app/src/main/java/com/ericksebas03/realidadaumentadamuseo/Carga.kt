package com.ericksebas03.realidadaumentadamuseo
import com.ericksebas03.realidadaumentadamuseo.R
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class Carga : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carga)

        // Crear un Handler para esperar 3 segundos (3000 ms)
        Handler().postDelayed({
            // Iniciar la siguiente actividad después de 3 segundos
            val intent = Intent(this, com.ericksebas03.realidadaumentadamuseo.MainActivity :: class.java)
            startActivity(intent)
            finish()  // Finalizar la SplashActivity para que no se regrese a ella
        }, 2000)  // 3000 ms = 3 segundos
    }
}