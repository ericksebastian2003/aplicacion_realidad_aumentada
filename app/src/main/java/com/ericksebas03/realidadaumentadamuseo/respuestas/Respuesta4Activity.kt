package com.ericksebas03.realidadaumentadamuseo.respuestas
import android.content.Intent
import com.ericksebas03.realidadaumentadamuseo.R
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ericksebas03.realidadaumentadamuseo.AdivinanzaState
import com.ericksebas03.realidadaumentadamuseo.adivinanzas.Adivinanza4Activity
import com.google.ar.core.Config
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.math.Position
import com.ericksebas03.realidadaumentadamuseo.SeccionesActivity

class Respuesta4Activity : AppCompatActivity() {
    private lateinit var sceneView: ArSceneView
    private lateinit var btnsegundapantalla: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        AdivinanzaState.adivinanzaActiva = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respuesta4ar)
        // Inicializa el botón después de configurar el layout
        btnsegundapantalla = findViewById(R.id.actionButton)
        sceneView = findViewById<ArSceneView>(R.id.sceneView).apply {
            this.lightEstimationMode = Config.LightEstimationMode.DISABLED
        }
        btnsegundapantalla.setOnClickListener {
            val intent = Intent(this, SeccionesActivity ::class.java)
            startActivity(intent)
        }
        placeModels()
    }

    private fun placeModels() {
        sceneView.planeRenderer.isVisible = false
        val models = listOf(
            Pair("models/oso.glb", Position(0f, 0f, 0f)),
        )

        models.forEach { (glbFileLocation, position) ->
            val modelNode = ArModelNode(sceneView.engine).apply {
                loadModelGlbAsync(
                    glbFileLocation = glbFileLocation,
                    scaleToUnits = 1f,
                    centerOrigin = position
                )
            }
            // Agregar el nuevo nodo modelo a la escena
            sceneView.addChild(modelNode)
            modelNode.anchor()

        }
    }
    override fun onDestroy() {
        super.onDestroy()

    }
}