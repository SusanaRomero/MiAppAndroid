package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoBebidasCrearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_bebidas_crear)

        val botonCocteles = findViewById<Button>(R.id.buttonCocteles)
        val botonJugos = findViewById<Button>(R.id.buttonJugos)

        botonCocteles.setOnClickListener {
            val intent = Intent(this, CrearRecetaCoctelesActivity::class.java)
            startActivity(intent)
        }

        botonJugos.setOnClickListener {
            val intent = Intent(this, CrearRecetaJugosActivity::class.java)
            startActivity(intent)
        }
    }
}
