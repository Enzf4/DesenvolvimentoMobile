package com.example.filmefavorito.View

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.filmefavorito.Model.Movie
import com.example.filmefavorito.Model.MovieRepositoryImpl
import com.example.filmefavorito.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val movieRepository = MovieRepositoryImpl()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val titleEditText = findViewById<EditText>(R.id.edt_Titulo)
        val directorEditText = findViewById<EditText>(R.id.edt_diretor)
        val registerButton = findViewById<Button>(R.id.btn_cadastrar)
        val nextScreenButton = findViewById<FloatingActionButton>(R.id.fab_avanca)

        registerButton.setOnClickListener {
            val movieTitle = titleEditText.text.toString()
            val movieDirector = directorEditText.text.toString()
            val newMovie = Movie(movieTitle, movieDirector)
            movieRepository.addMovie(newMovie)
            titleEditText.text.clear()
            directorEditText.text.clear()
            
            val successDialog = AlertDialog.Builder(this)
            successDialog.setTitle("Sucesso")
            successDialog.setMessage("Cadastro Ok!")
            val alert = successDialog.create()
            alert.show()
        }
        
        nextScreenButton.setOnClickListener {
            val intent = Intent(this, ListaFilmesActivity::class.java)
            startActivity(intent)
        }
    }
}