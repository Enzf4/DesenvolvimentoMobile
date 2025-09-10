package com.example.registratarefas.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registratarefas.Model.Tarefa
import com.example.registratarefas.Model.TarefaDaoImpl
import com.example.registratarefas.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
        private val tarefaRepository = TarefaDaoImpl()
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }


            val editTextTarefaNome = findViewById<EditText>(R.id.edt_Nome)
            val editTextTarefaDescricao = findViewById<EditText>(R.id.edt_descricao)
            val buttonSalvarTarefa = findViewById<Button>(R.id.btn_cadastrar)
            val fabListarTarefas = findViewById<FloatingActionButton>(R.id.fab_avanca)

            buttonSalvarTarefa.setOnClickListener{
                val tituloTarefa = editTextTarefaNome.text.toString()
                val descricaoTarefa = editTextTarefaDescricao.text.toString()
                val novaTarefa = Tarefa(tituloTarefa, descricaoTarefa)
                tarefaRepository.adicionarTarefa(novaTarefa)
                editTextTarefaNome.text.clear()
                editTextTarefaDescricao.text.clear()
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setTitle("Sucesso")
                dialogBuilder.setMessage("Cadastro Ok!")
                val dialogSucesso =  dialogBuilder.create()
                dialogSucesso.show()
            }
            fabListarTarefas.setOnClickListener {
                val intent = Intent(this, ListasTarefaActivity::class.java)
                startActivity(intent)
            }
        }

    }