package com.susi.cocinaatusazon

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuscarRecetasCoctelesActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecetasAdapter
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var videoBackground: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_receta_cocteles)

        // Inicializar vistas
        initializeViews()

        // Configurar video de fondo
        setupVideoBackground()

        // Cargar recetas desde la base de datos
        loadRecetas()
    }

    /**
     * Inicializa las vistas del layout.
     */
    private fun initializeViews() {
        recyclerView = findViewById(R.id.recyclerViewBuscarRecetaCocteles)
        recyclerView.layoutManager = LinearLayoutManager(this)
        videoBackground = findViewById(R.id.video_fondo_cocteles)
        databaseHelper = DatabaseHelper(this)
    }

    /**
     * Configura el video de fondo para que se reproduzca en bucle.
     */
    private fun setupVideoBackground() {
        val videoUri = Uri.parse("android.resource://${packageName}/raw/video_fondo_cocteles")
        videoBackground.setVideoURI(videoUri)

        videoBackground.setOnPreparedListener { mediaPlayer ->
            mediaPlayer.isLooping = true // Configura el video para que se reproduzca en bucle
            videoBackground.start() // Inicia la reproducción
        }

        videoBackground.setOnErrorListener { _, what, extra ->
            android.util.Log.e("VideoView", "Error al reproducir el video: what=$what, extra=$extra")
            true // Maneja el error
        }
    }

    /**
     * Carga las recetas desde la base de datos y las muestra en el RecyclerView.
     */
    private fun loadRecetas() {
        val listaRecetas = databaseHelper.getRecetasByTipo("Cocteles")

        adapter = RecetasAdapter(listaRecetas) { receta ->
            navigateToDetalleReceta(receta)
        }
        recyclerView.adapter = adapter
    }

    /**
     * Navega a la actividad de detalle de receta, enviando los datos de la receta seleccionada.
     * @param receta La receta seleccionada.
     */
    private fun navigateToDetalleReceta(receta: RecetaModel) {
        val intent = Intent(this, DetalleRecetaActivity::class.java).apply {
            putExtra("nombre", receta.nombre)
            putExtra("categoria", receta.categoria)
            putExtra("ingredientes", receta.ingredientes)
            putExtra("preparacion", receta.preparacion)
        }
        startActivity(intent)
    }
}

