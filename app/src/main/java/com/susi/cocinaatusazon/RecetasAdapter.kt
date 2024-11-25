package com.susi.cocinaatusazon


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecetasAdapter(
    private val recetasList: List<RecetaModel>,
    private val onItemClicked: (RecetaModel) -> Unit
) : RecyclerView.Adapter<RecetasAdapter.RecetaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecetaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_receta, parent, false)
        return RecetaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecetaViewHolder, position: Int) {
        val receta = recetasList[position]
        holder.bind(receta)
        holder.itemView.setOnClickListener { onItemClicked(receta) }
    }

    override fun getItemCount(): Int = recetasList.size

    inner class RecetaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nombreTextView: TextView = itemView.findViewById(R.id.textViewNombre)
        private val categoriaTextView: TextView = itemView.findViewById(R.id.textViewCategoria)

        fun bind(receta: RecetaModel) {
            nombreTextView.text = receta.nombre
            categoriaTextView.text = receta.categoria
        }
    }
}
