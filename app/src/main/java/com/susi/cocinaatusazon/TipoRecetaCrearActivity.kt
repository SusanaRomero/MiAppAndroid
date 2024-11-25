package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoRecetaCrearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_recetas_crear)

        // Configurar botones y sus listeners
        val buttonPlatoFuerte: Button = findViewById(R.id.buttonPlatoFuerte)
        val buttonBebidas: Button = findViewById(R.id.buttonBebidas)
        val buttonReposteria: Button = findViewById(R.id.buttonReposteria)
        val buttonSopas: Button = findViewById(R.id.buttonSopas)
        val buttonFitness: Button = findViewById(R.id.buttonFitness)
        val buttonCarnes: Button = findViewById(R.id.buttonCarnes)

        buttonPlatoFuerte.setOnClickListener {
            // Navegar a la actividad de crear receta de Plato Fuerte
            val intent = Intent(this, TipoPlatoFuerteCrearActivity::class.java)
            startActivity(intent)
        }

        buttonBebidas.setOnClickListener {
            // Navegar a la actividad de crear receta de Bebidas
            val intent = Intent(this, TipoRecetaCrearActivity::class.java)
            startActivity(intent)
        }

        buttonReposteria.setOnClickListener {
            // Navegar a la actividad de crear receta de Repostería
            val intent = Intent(this, TipoReposteriaCrearActivity::class.java)
            startActivity(intent)
        }

        buttonSopas.setOnClickListener {
            // Navegar a la actividad de crear receta de Sopas
            val intent = Intent(this, CrearRecetaSopasActivity::class.java)
            startActivity(intent)
        }

        buttonFitness.setOnClickListener {
            // Navegar a la actividad de crear receta de Fitness
            val intent = Intent(this, TipoFitnessCrearActivity::class.java)
            startActivity(intent)
        }

        buttonCarnes.setOnClickListener {
            // Navegar a la actividad de crear receta de Carnes
            val intent = Intent(this, CrearRecetaCarnesActivity::class.java)
            startActivity(intent)
        }
        buttonBebidas.setOnClickListener {
            // Navegar a la actividad de crear receta de bebidas
            val intent = Intent(this, TipoBebidasCrearActivity::class.java)
            startActivity(intent)
        }

    }
}
