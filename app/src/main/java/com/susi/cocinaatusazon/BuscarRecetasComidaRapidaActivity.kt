package com.susi.cocinaatusazon
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuscarRecetasComidaRapidaActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecetasAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_recetas_comida_rapida)

        recyclerView = findViewById(R.id.recyclerViewBuscarRecetaComidaRapida)
        recyclerView.layoutManager = LinearLayoutManager(this)

        databaseHelper = DatabaseHelper(this)
        val listaRecetas = databaseHelper.getRecetasByTipo("Comida rapida")

        adapter = RecetasAdapter(listaRecetas) { receta ->
            val intent = Intent(this, DetalleRecetaActivity::class.java).apply {
                putExtra("nombre", receta.nombre)
                putExtra("categoria", receta.categoria)
                putExtra("ingredientes", receta.ingredientes)
                putExtra("preparacion", receta.preparacion)
            }
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}


