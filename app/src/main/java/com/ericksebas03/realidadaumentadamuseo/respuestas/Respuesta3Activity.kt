package com.ericksebas03.realidadaumentadamuseo.respuestas

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.R
import java.util.Locale

class Respuesta3Activity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech // Declaración correcta para TTS
    private lateinit var textToRead: TextView // Declaración para TextView
    private lateinit var speakerButton: Button // Declaración para el botón

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respuesta3ar) // Asegúrate de usar el layout correcto

        // Inicializar vistas
        textToRead = findViewById(R.id.textToRead)
        speakerButton = findViewById(R.id.btn_escuchar)
        val continuar = findViewById<Button>(R.id.btn_continuar)

        // Inicializar Text-To-Speech
        tts = TextToSpeech(this, this)

        // Configurar el botón
        speakerButton.setOnClickListener {
            val text = textToRead.text.toString()
            if (text.isNotEmpty()) {
                speakText(text)
            }
        }
        //Botón de continuar
        continuar.setOnClickListener{
            // Crear un Intent para iniciar Respuesta1Activity
            //val intent = Intent(this, Respuesta1Activity::class.java)
            // Iniciar Respuesta1Activity
            //startActivity(intent)
        }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // Configurar idioma a Español - Ecuador (es-EC)
            val result = tts.setLanguage(Locale("es", "EC"))
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                speakerButton.isEnabled = false
                textToRead.text = "El idioma seleccionado no es compatible con TTS."
            }
        } else {
            textToRead.text = "Error al inicializar Text-to-Speech."
        }
    }

    private fun speakText(text: String) {
        // Leer el texto en voz alta
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Detener TTS para liberar recursos
        if (::tts.isInitialized) {
            tts.stop()
            tts.shutdown()
        }
    }
}
