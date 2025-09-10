package br.unisanta.listausuarios.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.listausuarios.R
import br.unisanta.listausuarios.adapter.UsuarioAdapter
import br.unisanta.listausuarios.dao.UsuarioDAO

class ListaUsuariosActivity : AppCompatActivity(R.layout.activity_lista_usuarios) {
    private val dao = UsuarioDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rvUsuarios = findViewById<RecyclerView>(R.id.rv_usuarios)
        val usuarios = dao.get()

        rvUsuarios.layoutManager = LinearLayoutManager(this)
        rvUsuarios.adapter = UsuarioAdapter(usuarios)
    }
}