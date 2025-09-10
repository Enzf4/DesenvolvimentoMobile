package br.unisanta.listausuarios.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.listausuarios.R

class UsuarioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txvEmail = itemView.findViewById<TextView>(R.id.txv_email)
}