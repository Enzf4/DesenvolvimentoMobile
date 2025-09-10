package com.example.registratarefas.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.registratarefas.Model.Tarefa
import com.example.registratarefas.R

class TarefaAdapter(private val listaTarefas: MutableList<Tarefa>) :
    RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitulo = itemView.findViewById<TextView>(R.id.txv_nome)
        val textViewDetalhes = itemView.findViewById<TextView>(R.id.txv_descricao)
        val buttonFinalizar = itemView.findViewById<Button>(R.id.btn_concluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefaAtual = listaTarefas[position]
        holder.textViewTitulo.text = tarefaAtual.titulo
        holder.textViewDetalhes.text = tarefaAtual.detalhes

        holder.buttonFinalizar.setOnClickListener {
            // Remove a tarefa da lista
            listaTarefas.removeAt(position)
            // Atualiza o RecyclerView
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, listaTarefas.size)
        }
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }
}
