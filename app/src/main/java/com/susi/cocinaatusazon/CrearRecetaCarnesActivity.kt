package com.susi.cocinaatusazon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CrearRecetaCarnesActivity : AppCompatActivity() {

    private lateinit var editTextNombreReceta: EditText
    private lateinit var editTextUtensilios: EditText
    private lateinit var editTextTiempoAproximado: EditText
    private lateinit var editTextIngredientes: EditText
    private lateinit var editTextPreparacion: EditText
    private lateinit var editTextConsejos: EditText
    private lateinit var imageViewFotoFinal: ImageView
    private lateinit var buttonGuardarReceta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_receta_carnes)

        // Inicializar los elementos de la interfaz de usuario
        editTextNombreReceta = findViewById(R.id.editTextNombreRecetaCarnes)
        editTextUtensilios = findViewById(R.id.editTextUtensiliosCarnes)
        editTextTiempoAproximado = findViewById(R.id.editTextTiempoAproximadoCarnes)
        editTextIngredientes = findViewById(R.id.editTextIngredientesCarnes)
        editTextPreparacion = findViewById(R.id.editTextPreparacionCarnes)
        editTextConsejos = findViewById(R.id.editTextConsejoCarnes)
        imageViewFotoFinal = findViewById(R.id.imageViewFotoFinalCarnes)
        buttonGuardarReceta = findViewById(R.id.buttonGuardarRecetaCarnes)

        // Configurar el botón para guardar la receta
        buttonGuardarReceta.setOnClickListener {
            guardarReceta()
        }
    }

    private fun guardarReceta() {
        val nombre = editTextNombreReceta.text.toString()
        val utensilios = editTextUtensilios.text.toString()
        val tiempoAproximado = editTextTiempoAproximado.text.toString()
        val ingredientes = editTextIngredientes.text.toString()
        val preparacion = editTextPreparacion.text.toString()


        if (nombre.isBlank() || utensilios.isBlank() || tiempoAproximado.isBlank() || ingredientes.isBlank() || preparacion.isBlank()) {
            Toast.makeText(this, "Por favor completa todos los campos requeridos", Toast.LENGTH_SHORT).show()
        } else {
            val receta = RecetaModel(
                nombre = nombre,
                categoria = "Carnes",
                tiempoAproximado = tiempoAproximado,
                utensilios = utensilios,
                ingredientes = ingredientes,
                preparacion = preparacion
            )
            val dbHelper = DatabaseHelper(this)
            val result = dbHelper.insertarReceta(receta)

            if (result != -1L) {
                Toast.makeText(this, "Receta de carnes guardada exitosamente", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Error al guardar la receta", Toast.LENGTH_LONG).show()
            }
        }
    }
}