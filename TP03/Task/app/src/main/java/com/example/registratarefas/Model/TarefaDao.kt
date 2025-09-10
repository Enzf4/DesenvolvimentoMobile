package com.example.registratarefas.Model

interface TarefaDao {

    fun adicionarTarefa(tarefa: Tarefa)

    fun obterTarefas(): List<Tarefa>
}