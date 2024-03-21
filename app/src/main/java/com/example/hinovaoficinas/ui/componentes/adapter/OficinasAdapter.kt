package com.example.hinovaoficinas.ui.componentes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.hinovaoficinas.R
import com.example.hinovaoficinas.models.OficinaApiModel

class OficinasAdapter(
    private var listaOficinas: List<OficinaApiModel>,
    private var listener: RecyclerViewEvent
): RecyclerView.Adapter<OficinasAdapter.ViewHolder>() {


   inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvNomeOficina: TextView = view.findViewById(R.id.tvNomeOficina)
        val tvNota: TextView = view.findViewById(R.id.tvNota)
        val tvDescricaoItem: TextView = view.findViewById(R.id.tvDescricaoItem)
        init {
            view.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClicked(position)
            }

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_oficina, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listaOficinas[position]
        holder.apply {
            tvNomeOficina.text = item.Nome
            tvNota.text = "Avaliação "+item.AvaliacaoUsuario
            tvDescricaoItem.text = item.DescricaoCurta
        }

    }
    override fun getItemCount(): Int {
        return listaOficinas.size
    }

    interface RecyclerViewEvent{
        fun onItemClicked(position: Int)
    }

}

