package com.ericksebas03.realidadaumentadamuseo.respuestas
import com.ericksebas03.realidadaumentadamuseo.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Config
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.math.Position

class Respuesta4Activity : AppCompatActivity() {
    private lateinit var sceneView: ArSceneView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_respuesta4ar)

        sceneView = findViewById<ArSceneView>(R.id.sceneView).apply {
            this.lightEstimationMode = Config.LightEstimationMode.DISABLED
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