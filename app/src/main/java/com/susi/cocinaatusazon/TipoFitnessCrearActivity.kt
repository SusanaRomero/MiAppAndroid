package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoFitnessCrearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_fitness_crear)

        val buttonEnsaladas = findViewById<Button>(R.id.buttonEnsaladas)
        val buttonBatidos = findViewById<Button>(R.id.buttonBatidos)

        buttonEnsaladas.setOnClickListener {
            startActivity(Intent(this, CrearRecetaEnsaladasActivity::class.java))
        }

        buttonBatidos.setOnClickListener {
            startActivity(Intent(this, CrearRecetaBatidosActivity::class.java))
        }
    }
}
