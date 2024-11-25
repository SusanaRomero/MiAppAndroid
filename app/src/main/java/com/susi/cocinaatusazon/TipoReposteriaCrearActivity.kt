package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoReposteriaCrearActivity : AppCompatActivity() {

    private lateinit var buttonPanaderiaDulce: Button
    private lateinit var buttonPanaderiaSalada: Button
    private lateinit var buttonTortasYPasteles: Button
    private lateinit var buttonPostresFrios: Button
    private lateinit var buttonPasabocas: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_reposterias_crear)

        buttonPanaderiaDulce = findViewById(R.id.buttonPanaderiaDulce)
        buttonPanaderiaSalada = findViewById(R.id.buttonPanaderiaSalada)
        buttonTortasYPasteles = findViewById(R.id.buttonTortasYPasteles)
        buttonPostresFrios = findViewById(R.id.buttonPostresFrios)
        buttonPasabocas = findViewById(R.id.buttonPasabocas)

        buttonPanaderiaDulce.setOnClickListener {
            val intent = Intent(this, CrearRecetaPanaderiaDulceActivity::class.java)
            startActivity(intent)
        }

        buttonPanaderiaSalada.setOnClickListener {
            val intent = Intent(this, CrearRecetaPanaderiaSaladaActivity::class.java)
            startActivity(intent)
        }

        buttonTortasYPasteles.setOnClickListener {
            val intent = Intent(this, CrearRecetaTortasPastelesActivity::class.java)
            startActivity(intent)
        }

        buttonPostresFrios.setOnClickListener {
            val intent = Intent(this, CrearRecetaPostresFriosActivity::class.java)
            startActivity(intent)
        }

        buttonPasabocas.setOnClickListener {
            val intent = Intent(this, CrearRecetaPasabocasActivity::class.java)
            startActivity(intent)
        }
    }
}
