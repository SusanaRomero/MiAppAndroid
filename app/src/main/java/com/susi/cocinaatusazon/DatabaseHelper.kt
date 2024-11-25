package com.susi.cocinaatusazon
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.Cursor

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "CocinaATuSazon.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createRecetasTable = """
            CREATE TABLE recetas (
                id_receta INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre TEXT NOT NULL,
                categoria TEXT NOT NULL,
                tiempo_aproximado TEXT,
                utensilios TEXT,
                ingredientes TEXT,
                preparacion TEXT
            )
        """
        db.execSQL(createRecetasTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS recetas")
        onCreate(db)
    }

    // Método para insertar receta en la base de datos
    fun insertarReceta(receta: RecetaModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues().apply {
            put("nombre", receta.nombre)
            put("categoria", receta.categoria)
            put("tiempo_aproximado", receta.tiempoAproximado)
            put("utensilios", receta.utensilios)
            put("ingredientes", receta.ingredientes)
            put("preparacion", receta.preparacion)
        }
        val result = db.insert("recetas", null, contentValues)
        db.close()
        return result
    }

    // Método para obtener recetas por tipo/categoría específica
    fun getRecetasByTipo(tipo: String): List<RecetaModel> {
        val listaRecetas = mutableListOf<RecetaModel>()
        val db = this.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM recetas WHERE LOWER(categoria) = LOWER(?)", arrayOf(tipo))



        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val categoria = cursor.getString(cursor.getColumnIndexOrThrow("categoria"))
                val tiempoAproximado = cursor.getString(cursor.getColumnIndexOrThrow("tiempo_aproximado"))
                val utensilios = cursor.getString(cursor.getColumnIndexOrThrow("utensilios"))
                val ingredientes = cursor.getString(cursor.getColumnIndexOrThrow("ingredientes"))
                val preparacion = cursor.getString(cursor.getColumnIndexOrThrow("preparacion"))

                val receta = RecetaModel(
                    nombre = nombre,
                    categoria = categoria,
                    tiempoAproximado = tiempoAproximado,
                    utensilios = utensilios,
                    ingredientes = ingredientes,
                    preparacion = preparacion
                )
                listaRecetas.add(receta)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return listaRecetas
    }

}
