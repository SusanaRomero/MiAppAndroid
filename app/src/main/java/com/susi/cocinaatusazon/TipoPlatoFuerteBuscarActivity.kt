package com.susi.cocinaatusazon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class TipoPlatoFuerteBuscarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_plato_fuerte_buscar)

        val buttonBuscarArroz = findViewById<Button>(R.id.buttonBuscarArroz)
        val buttonBuscarPasta = findViewById<Button>(R.id.buttonBuscarPasta)
        val buttonBuscarAlHorno = findViewById<Button>(R.id.buttonBuscarAlHorno)
        val buttonBuscarComidaRapida = findViewById<Button>(R.id.buttonBuscarComidaRapida)

        buttonBuscarArroz.setOnClickListener {
            val intent = Intent(this, BuscarRecetasArrozActivity::class.java)
            startActivity(intent)
        }

        buttonBuscarPasta.setOnClickListener {
            val intent = Intent(this, BuscarRecetasPastaActivity::class.java)
            startActivity(intent)
        }

        buttonBuscarAlHorno.setOnClickListener {
            val intent = Intent(this, BuscarRecetasAlHornoActivity::class.java)
            startActivity(intent)
        }

        buttonBuscarComidaRapida.setOnClickListener {
            val intent = Intent(this, BuscarRecetasComidaRapidaActivity::class.java)
            startActivity(intent)
        }
    }
}
