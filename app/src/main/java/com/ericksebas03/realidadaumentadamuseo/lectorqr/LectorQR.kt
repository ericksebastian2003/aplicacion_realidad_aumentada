package com.ericksebas03.realidadaumentadamuseo.lectorqr
import androidx.camera.core.Preview
import android.os.Bundle
import android.util.Size
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.OptIn
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.resolutionselector.ResolutionSelector
import androidx.camera.core.resolutionselector.ResolutionStrategy
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import android.Manifest
import android.content.Intent
import android.widget.Button
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage
import com.ericksebas03.realidadaumentadamuseo.R
import com.ericksebas03.realidadaumentadamuseo.databinding.ActivityLectorqrBinding
import com.google.mlkit.vision.barcode.BarcodeScanner
import com.google.mlkit.vision.barcode.common.Barcode
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.ericksebas03.realidadaumentadamuseo.AdivinanzaState
import com.ericksebas03.realidadaumentadamuseo.splashscreen.Splash2Activity
import com.ericksebas03.realidadaumentadamuseo.IntentarDeNuevoActivity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta1Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta2Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta3Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta4Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta5Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta6Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta7Activity
import com.ericksebas03.realidadaumentadamuseo.respuestas.Respuesta8Activity




class LectorQR : AppCompatActivity() {

    private lateinit var binding : ActivityLectorqrBinding

    private lateinit var cameraExecutor: ExecutorService

    private lateinit var barcodeScanner: BarcodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLectorqrBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cameraExecutor = Executors.newSingleThreadExecutor()

        val btngotoar: Button = findViewById(R.id.btn_gotoar)
        btngotoar.setOnClickListener {
            // Obtener el texto del TextView
            val scannedText = binding.resultTextView.text.toString()

            // Obtener la respuesta correcta desde el singleton
            val adivinanzaActiva = AdivinanzaState.adivinanzaActiva
            val respuestaCorrecta = AdivinanzaState.respuestasCorrectas[adivinanzaActiva]

            // Comprobar si el texto coincide con la respuesta correcta
            if (scannedText == respuestaCorrecta) {
                // Usamos when para redirigir a la pantalla correspondiente
                val intent = when (adivinanzaActiva) {
                    1 -> Intent(this, Respuesta1Activity::class.java)
                    2 -> Intent(this, Respuesta2Activity::class.java)
                    3 -> Intent(this, Respuesta3Activity::class.java)
                    4 -> Intent(this, Respuesta4Activity::class.java)
                    5 -> Intent(this, Respuesta5Activity::class.java)
                    6 -> Intent(this, Respuesta6Activity::class.java)
                    7 -> Intent(this, Respuesta7Activity::class.java)
                    8 -> Intent(this, Respuesta8Activity::class.java)
                    else -> Intent(this, IntentarDeNuevoActivity::class.java)
                }
                startActivity(intent)
            } else {
                // Redirigir a la pantalla de respuesta incorrecta
                val intent = Intent(this, IntentarDeNuevoActivity::class.java)
                startActivity(intent)
            }
        }


        barcodeScanner = BarcodeScanning.getClient()

        val requestPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
            if (isGranted) {
                startCamera()
            }else{
                binding.resultTextView.text = "Permisos de camara necesarios"
            }
        }

        requestPermissionLauncher.launch(Manifest.permission.CAMERA)
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        val screenSize = Size(1280,720)
        val resolutionSelector = ResolutionSelector.Builder().setResolutionStrategy(
            ResolutionStrategy(screenSize, ResolutionStrategy.FALLBACK_RULE_NONE)
        ).build()

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().setResolutionSelector(resolutionSelector)
                .build()
                .also {
                    it.setSurfaceProvider(binding.previewView.surfaceProvider)
                }

            val imageAnalyzer = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()
                .also{
                    it.setAnalyzer(cameraExecutor, { imageProxy ->
                        processImageProxy(imageProxy)
                    })
                }
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalyzer)
        }, ContextCompat.getMainExecutor(this) )

    }

    @OptIn(ExperimentalGetImage::class)
    private fun processImageProxy(imageProxy: ImageProxy){
        val mediaImage = imageProxy.image

        if (mediaImage != null){
            val image = InputImage.fromMediaImage(mediaImage,imageProxy.imageInfo.rotationDegrees)
            barcodeScanner.process(image)
                .addOnSuccessListener { barcodes ->
                    for (barcode in barcodes){
                        handleBarcode(barcode)
                    }
                }
                .addOnFailureListener {
                    binding.resultTextView.text = "Fallo al escanear el codigo"
                }
                .addOnCompleteListener{
                    imageProxy.close()
                }
        }
    }
    private fun handleBarcode(barcode: Barcode) {
        val txt = barcode.url?.url ?: barcode.displayValue
        if (txt != null){
            binding.resultTextView.text = txt
        }else {
            binding.resultTextView.text = "No se detecto codigo"
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        cameraExecutor.shutdown()
    }

}