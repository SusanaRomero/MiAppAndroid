package com.susi.cocinaatusazon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declaración de variables para los elementos del layout
    private lateinit var buttonCrearReceta: Button
    private lateinit var buttonBuscarReceta: Button
    private lateinit var titleLine1: TextView
    private lateinit var titleLine2: TextView
    private lateinit var videoBackground: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialización de referencias a los elementos del layout
        initializeViews()

        // Configuración del video de fondo
        setupVideoBackground()

        // Aplicar efecto de escritura para el título
        startTypingEffect()

        // Configuración de botones para navegar entre actividades
        setupButtonListeners()
    }

    /**
     * Inicializa las referencias a los elementos del layout.
     */
    private fun initializeViews() {
        buttonCrearReceta = findViewById(R.id.buttonCrearReceta)
        buttonBuscarReceta = findViewById(R.id.buttonBuscarReceta)
        titleLine1 = findViewById(R.id.titleLine1)
        titleLine2 = findViewById(R.id.titleLine2)
        videoBackground = findViewById(R.id.video_fondo)
    }

    /**
     * Configura el video de fondo en el VideoView.
     */
    private fun setupVideoBackground() {
        val videoUri = Uri.parse("android.resource://${packageName}/raw/video_fondo")
        videoBackground.setVideoURI(videoUri)

        videoBackground.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true // Reproduce el video en bucle
            mediaPlayer.setVolume(0f, 0f) // Silencia el video
            videoBackground.start()
        }

        videoBackground.setOnErrorListener { mediaPlayer, what, extra ->
            // En caso de error, registra el problema en Logcat
            android.util.Log.e("VideoView", "Error al reproducir el video: what=$what, extra=$extra")
            true // Indica que el error fue manejado
        }
    }

    /**
     * Inicia el efecto de escritura en las líneas del título.
     */
    private fun startTypingEffect() {
        applyTypingEffect(titleLine1, "COCINA A", delay = 150) {
            // Mostrar "SU SAZÓN" después de completar "COCINA A"
            titleLine2.visibility = TextView.VISIBLE
            applyTypingEffect(titleLine2, "SU SAZÓN", delay = 150)
        }
    }

    /**
     * Configura los listeners de los botones para la navegación.
     */
    private fun setupButtonListeners() {
        buttonCrearReceta.setOnClickListener {
            val intent = Intent(this, TipoRecetaCrearActivity::class.java)
            startActivity(intent)
        }

        buttonBuscarReceta.setOnClickListener {
            val intent = Intent(this, TipoRecetaBuscarActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Aplica un efecto de escritura a un TextView.
     *
     * @param textView TextView donde se aplicará el efecto.
     * @param text Texto completo que se mostrará.
     * @param delay Tiempo en milisegundos entre cada letra.
     * @param onComplete Callback que se ejecuta al completar la animación.
     */
    private fun applyTypingEffect(
        textView: TextView,
        text: String,
        delay: Long,
        onComplete: (() -> Unit)? = null
    ) {
        var index = 0
        val handler = Handler(Looper.getMainLooper())
        val typingRunnable = object : Runnable {
            override fun run() {
                if (index <= text.length) {
                    textView.text = text.substring(0, index++) // Actualiza el texto progresivamente
                    textView.requestLayout() // Recalcula el tamaño del TextView si es necesario
                    handler.postDelayed(this, delay) // Tiempo entre letras
                } else {
                    onComplete?.invoke() // Llama al callback al completar
                }
            }
        }
        handler.post(typingRunnable) // Inicia la animación
    }
}
