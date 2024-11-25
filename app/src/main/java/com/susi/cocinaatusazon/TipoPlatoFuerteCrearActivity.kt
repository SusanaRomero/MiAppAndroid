package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoPlatoFuerteCrearActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_platos_fuertes_crear)

        // Configurar botones y sus listeners
        val buttonArroz: Button = findViewById(R.id.buttonArroz)
        val buttonPasta: Button = findViewById(R.id.buttonPasta)
        val buttonAlHorno: Button = findViewById(R.id.buttonAlHorno)
        val buttonComidaRapida: Button = findViewById(R.id.buttonComidaRapida)

        buttonArroz.setOnClickListener {
            // Navegar a la actividad de crear receta de Arroz
            val intent = Intent(this, CrearRecetaArrozActivity::class.java)
            startActivity(intent)
        }

        buttonPasta.setOnClickListener {
            // Navegar a la actividad de crear receta de Pasta
            val intent = Intent(this, CrearRecetaPastaActivity::class.java)
            startActivity(intent)
        }

        buttonAlHorno.setOnClickListener {
            // Navegar a la actividad de crear receta Al Horno
            val intent = Intent(this, CrearRecetaAlHornoActivity::class.java)
            startActivity(intent)
        }

        buttonComidaRapida.setOnClickListener {
            // Navegar a la actividad de crear receta de Comida Rápida
            val intent = Intent(this, CrearRecetaComidaRapidaActivity::class.java)
            startActivity(intent)
        }
    }
}
