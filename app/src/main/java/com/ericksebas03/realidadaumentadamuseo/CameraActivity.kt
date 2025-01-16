package com.ericksebas03.realidadaumentadamuseo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
//import com.google.mlkit.vision.barcode.Barcode
import com.google.mlkit.vision.common.InputImage
import androidx.camera.core.ImageProxy
import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.camera.core.*
import com.ericksebas03.realidadaumentadamuseo.databinding.ActivityCameraBinding
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.BarcodeScanning
//Importar los componentes
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta1Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta2Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta3Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta4Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta5Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta6Activity
//import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta7Activity
//import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta8Activity
import com.ericksebas03.realidadaumentadamuseo.IntentarDeNuevoActivity


class CameraActivity : AppCompatActivity() {

    /*
    private lateinit var binding: ActivityCameraBinding
    private val cameraPermissionRequestCode = 100
    private lateinit var barcodeScanner: BarcodeScanner
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        /* binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Inicializa el escáner de códigos de barras (QR)
        barcodeScanner = BarcodeScanning.getClient()

        // Verifica si los permisos para la cámara están concedidos
        if (allPermissionsGranted()) {
            startCamera()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                cameraPermissionRequestCode
            )
        }
    }

    private fun allPermissionsGranted() = ContextCompat.checkSelfPermission(
        this, Manifest.permission.CAMERA
    ) == PackageManager.PERMISSION_GRANTED

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.viewFinder.surfaceProvider)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            val imageAnalysis = ImageAnalysis.Builder()
                .build()

            imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(this)) { imageProxy ->
                processImageProxy(imageProxy)
            }

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis)
            } catch (exc: Exception) {
                Log.e("CameraX :", "Error al vincular el caso de uso", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    private fun processImageProxy(imageProxy: ImageProxy) {
        val mediaImage = imageProxy.image
        if (mediaImage != null) {
            val inputImage = InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)

            barcodeScanner.process(inputImage)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes) {
                        val valueType = barcode.valueType
                        val activityName = intent.getStringExtra("ACTIVITY")
                        when (activityName) {
                            "Adivinanza1Activity" ->
                                if (valueType == Barcode.TYPE_URL) {
                                val url = barcode.displayValue
                                if (url == "https://qr.codes/NmRbLj") {
                                    val intent = Intent(this, Respuesta1Activity::class.java)
                                    startActivity(intent)
                                    imageProxy.close()
                                    return@addOnSuccessListener
                                }
                                    else {
                                        val intent = Intent(this,IntentarDeNuevoActivity::class.java)
                                        intent.putExtra("NOMBRE_ACTIVITY",activityName)
                                }
                            }
                        }
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("BarcodeError : ", "Error al escanear el código QR", e)
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        if (requestCode == cameraPermissionRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startCamera()
            } else {
                Toast.makeText(this, "Se requiere permiso de la cámara", Toast.LENGTH_SHORT).show()
            }

    }

        */
    }
}