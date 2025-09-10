package br.unisanta.listausuarios.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.unisanta.listausuarios.R
import br.unisanta.listausuarios.model.Usuario
import br.unisanta.listausuarios.dao.UsuarioDAO

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val dao = UsuarioDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val edtEmail = findViewById<EditText>(R.id.edt_email)
        val edtSenha = findViewById<EditText>(R.id.edt_senha)

        val txvEsqueceuSenha = findViewById<TextView>(R.id.txv_esqueceu_senha)

        val btnLogar = findViewById<Button>(R.id.btn_logar)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)

        txvEsqueceuSenha.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Fale com o administrador")
            val alert = builder.create()
            alert.show()
        }

        btnLogar.setOnClickListener {
            val email = edtEmail.text.toString()
            val senha = edtSenha.text.toString()

            val usuario = Usuario(email, senha)

            if (dao.has(usuario)) {
                val intent = Intent(this, ListaUsuariosActivity::class.java)
                startActivity(intent)

                edtEmail.text.clear()
                edtSenha.text.clear()
            } else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage("Email ou senha inválidos")
                val alert = builder.create()
                alert.show()
            }
        }

        btnCadastrar.setOnClickListener {
            val email = edtEmail.text.toString()
            val senha = edtSenha.text.toString()

            val usuario = Usuario(email, senha)

            try {
                dao.add(usuario)

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Sucesso")
                builder.setMessage("Usuário cadastrado com sucesso")
                val alert = builder.create()
                alert.show()
            } catch (e: IllegalArgumentException) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Erro")
                builder.setMessage(e.message)
                val alert = builder.create()
                alert.show()
            }
        }
    }
}