package com.susi.cocinaatusazon
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BuscarRecetasAlHornoActivity : AppCompatActivity() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecetasAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_recetas_al_horno)

        recyclerView = findViewById(R.id.recyclerViewBuscarRecetaAlHorno)
        recyclerView.layoutManager = LinearLayoutManager(this)

        databaseHelper = DatabaseHelper(this)
        val listaRecetas = databaseHelper.getRecetasByTipo("Al Horno")

        Log.d("BuscarRecetasAlHorno", "Recetas obtenidas: ${listaRecetas.size}")

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
