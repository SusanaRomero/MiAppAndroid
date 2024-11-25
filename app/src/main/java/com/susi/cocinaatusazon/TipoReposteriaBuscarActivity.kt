package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoReposteriaBuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_reposteria_buscar)

        // Botón para buscar recetas de Panadería Dulce
        val buttonBuscarPanaderiaDulce = findViewById<Button>(R.id.buttonBuscarPanaderiaDulce)
        buttonBuscarPanaderiaDulce.setOnClickListener {
            val intent = Intent(this, BuscarRecetasPanaderiaDulceActivity::class.java)
            startActivity(intent)
        }

        // Botón para buscar recetas de Panadería Salada
        val buttonBuscarPanaderiaSalada = findViewById<Button>(R.id.buttonBuscarPanaderiaSalada)
        buttonBuscarPanaderiaSalada.setOnClickListener {
            val intent = Intent(this, BuscarRecetasPanaderiaSaladaActivity::class.java)
            startActivity(intent)
        }

        // Botón para buscar recetas de Tortas y Pasteles
        val buttonBuscarTortasPasteles = findViewById<Button>(R.id.buttonBuscarTortasPasteles)
        buttonBuscarTortasPasteles.setOnClickListener {
            val intent = Intent(this, BuscarRecetasTortasPastelesActivity::class.java)
            startActivity(intent)
        }

        // Botón para buscar recetas de Postres Fríos
        val buttonBuscarPostresFrios = findViewById<Button>(R.id.buttonBuscarPostresFrios)
        buttonBuscarPostresFrios.setOnClickListener {
            val intent = Intent(this, BuscarRecetasPostresFriosActivity::class.java)
            startActivity(intent)
        }

        // Botón para buscar recetas de Pasabocas
        val buttonBuscarPasabocas = findViewById<Button>(R.id.buttonBuscarPasabocas)
        buttonBuscarPasabocas.setOnClickListener {
            val intent = Intent(this, BuscarRecetasPasabocasActivity::class.java)
            startActivity(intent)
        }
    }
}
