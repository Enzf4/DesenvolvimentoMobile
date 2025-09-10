package com.example.registratarefas.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.registratarefas.Adapter.TarefaAdapter
import com.example.registratarefas.Model.Tarefa
import com.example.registratarefas.Model.TarefaDaoImpl
import com.example.registratarefas.R

class ListasTarefaActivity : AppCompatActivity(R.layout.activity_listas_tarefa) {
        private val tarefaRepository = TarefaDaoImpl()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            val recyclerViewTarefas = findViewById<RecyclerView>(R.id.rv_tarefa)
            val listaTarefas = tarefaRepository.obterTarefas()
            recyclerViewTarefas.layoutManager = LinearLayoutManager(this)
            recyclerViewTarefas.adapter = TarefaAdapter(listaTarefas)

        }
}