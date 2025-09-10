package com.example.registratarefas.Model

class TarefaDaoImpl:TarefaDao {
    companion object {
        private val listaTarefas = mutableListOf<Tarefa>()
    }

    override fun adicionarTarefa(tarefa: Tarefa) {
        listaTarefas.add(tarefa)
    }

    override fun obterTarefas(): MutableList<Tarefa> {
        return listaTarefas
    }
}