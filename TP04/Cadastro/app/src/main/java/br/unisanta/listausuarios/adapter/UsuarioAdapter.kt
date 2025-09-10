package br.unisanta.listausuarios.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.listausuarios.R
import br.unisanta.listausuarios.viewholder.UsuarioViewHolder
import br.unisanta.listausuarios.model.Usuario

class UsuarioAdapter(
    private val usuarios: MutableList<Usuario>
) : RecyclerView.Adapter<UsuarioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_usuario, parent, false)

        return UsuarioViewHolder(view)
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]

        holder.txvEmail.text = usuario.email
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }
}