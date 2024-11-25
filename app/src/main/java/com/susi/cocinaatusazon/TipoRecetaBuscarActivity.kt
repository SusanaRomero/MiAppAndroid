package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoRecetaBuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_receta_buscar)

        // Inicializar los botones
        val buttonBuscarPlatoFuerte = findViewById<Button>(R.id.buttonBuscarPlatoFuerte)
        val buttonBuscarBebidas = findViewById<Button>(R.id.buttonBuscarBebidas)
        val buttonBuscarReposteria = findViewById<Button>(R.id.buttonBuscarReposteria)
        val buttonBuscarSopas = findViewById<Button>(R.id.buttonBuscarSopas)
        val buttonBuscarFitness = findViewById<Button>(R.id.buttonBuscarFitness)
        val buttonBuscarCarnes = findViewById<Button>(R.id.buttonBuscarCarnes)

        // Configurar los intents para cada botón
        buttonBuscarPlatoFuerte.setOnClickListener {
            startActivity(Intent(this, TipoPlatoFuerteBuscarActivity::class.java))
        }

        buttonBuscarBebidas.setOnClickListener {
            startActivity(Intent(this, TipoBebidasBuscarActivity::class.java))
        }

        buttonBuscarReposteria.setOnClickListener {
            startActivity(Intent(this, TipoReposteriaBuscarActivity::class.java))
        }

        buttonBuscarSopas.setOnClickListener {
            startActivity(Intent(this, BuscarRecetasSopasActivity::class.java))
        }

        buttonBuscarFitness.setOnClickListener {
            startActivity(Intent(this, TipoFitnessBuscarActivity::class.java))
        }

        buttonBuscarCarnes.setOnClickListener {
            startActivity(Intent(this, BuscarRecetasCarnesActivity::class.java))
        }
    }
}
