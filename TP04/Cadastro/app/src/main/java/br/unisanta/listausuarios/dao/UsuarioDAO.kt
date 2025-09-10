package br.unisanta.listausuarios.dao

import android.R
import br.unisanta.listausuarios.model.Usuario

class UsuarioDAO {
    companion object {
        val usuarios = mutableListOf<Usuario>()
    }

    fun get(): MutableList<Usuario> {
        return usuarios;
    }

    fun isEmailValid(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\$"
        return email.matches(emailRegex.toRegex())
    }

    fun isEmailRegistered(email: String): Boolean {
        return usuarios.map { it.email }.contains(email)
    }

    fun add(usuario: Usuario) {
        if (!isEmailValid(usuario.email)) {
            throw IllegalArgumentException("Email inválido")
        }

        if (isEmailRegistered(usuario.email)) {
            throw IllegalArgumentException("Email já existe")
        }

        usuarios.add(usuario)
    }

    fun has(usuario: Usuario): Boolean {
        return usuarios.contains(usuario)
    }
}