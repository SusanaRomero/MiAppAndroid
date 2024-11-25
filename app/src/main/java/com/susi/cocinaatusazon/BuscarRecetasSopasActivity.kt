package com.susi.cocinaatusazon
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuscarRecetasSopasActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecetasAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_recetas_sopas)

        recyclerView = findViewById(R.id.recyclerViewBuscarRecetaSopas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        databaseHelper = DatabaseHelper(this)
        val listaRecetas = databaseHelper.getRecetasByTipo("Sopas")

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
