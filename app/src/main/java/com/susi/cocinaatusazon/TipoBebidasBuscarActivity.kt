package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoBebidasBuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_bebidas_buscar)

        val buttonBuscarCocteles = findViewById<Button>(R.id.buttonBuscarCocteles)
        val buttonBuscarJugos = findViewById<Button>(R.id.buttonBuscarJugos)

        // Configurar el clic para el botón de buscar cocteles
        buttonBuscarCocteles.setOnClickListener {
            // Lanza la actividad para mostrar las recetas de cocteles
            val intent = Intent(this, BuscarRecetasCoctelesActivity::class.java)
            startActivity(intent)
        }

        // Configurar el clic para el botón de buscar jugos
        buttonBuscarJugos.setOnClickListener {
            // Lanza la actividad para mostrar las recetas de jugos
            val intent = Intent(this, BuscarRecetasJugosActivity::class.java)
            startActivity(intent)
        }
    }
}
