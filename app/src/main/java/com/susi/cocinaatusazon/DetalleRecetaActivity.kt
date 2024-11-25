package com.susi.cocinaatusazon

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetalleRecetaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_receta)

        val nombre = intent.getStringExtra("nombre")
        val categoria = intent.getStringExtra("categoria")
        val ingredientes = intent.getStringExtra("ingredientes")
        val preparacion = intent.getStringExtra("preparacion")

        findViewById<TextView>(R.id.textViewNombre).text = nombre
        findViewById<TextView>(R.id.textViewCategoria).text = categoria
        findViewById<TextView>(R.id.textViewIngredientes).text = ingredientes
        findViewById<TextView>(R.id.textViewPreparacion).text = preparacion
    }
}
