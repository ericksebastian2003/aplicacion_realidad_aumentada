package com.ericksebas03.realidadaumentadamuseo
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Obtener la referencia del Button
        val btnLectorQR: Button = findViewById(R.id.btn_continuar1)

        // Configurar el OnClickListener para abrir el lector de QR
        btnLectorQR.setOnClickListener {
            // Redirigir a la actividad LectorQRActivity (usando ZXing o tu lector preferido)
            val intent = Intent(this, com.ericksebas03.realidadaumentadamuseo.splashscreen.Splash2Activity ::class.java) // ZXing CaptureActivity
            startActivity(intent)
        }
    }

}
