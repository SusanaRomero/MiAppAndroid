package com.susi.cocinaatusazon

data class RecetaModel(
    val id: Int = 0, // ID con valor predeterminado para auto-generarse
    val nombre: String,
    val categoria: String,
    val tiempoAproximado: String,
    val utensilios: String,
    val ingredientes: String,
    val preparacion: String,
)
