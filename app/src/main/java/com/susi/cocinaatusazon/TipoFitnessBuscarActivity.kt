package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoFitnessBuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_fitness_buscar)

        val buttonBuscarEnsaladas = findViewById<Button>(R.id.buttonBuscarEnsaladas)
        val buttonBuscarBatidos = findViewById<Button>(R.id.buttonBuscarBatidos)

        buttonBuscarEnsaladas.setOnClickListener {
            startActivity(Intent(this, BuscarRecetasEnsaladasActivity::class.java))
        }

        buttonBuscarBatidos.setOnClickListener {
            startActivity(Intent(this, BuscarRecetasBatidosActivity::class.java))
        }
    }
}

