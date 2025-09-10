package com.example.filmefavorito.View

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.filmefavorito.R
import com.example.filmefavorito.Adapter.MovieAdapter
import com.example.filmefavorito.Model.Movie
import com.example.filmefavorito.Model.MovieRepositoryImpl

class ListaFilmesActivity : AppCompatActivity(R.layout.activity_lista_filmes) {
    private val movieRepository = MovieRepositoryImpl()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val moviesRecyclerView = findViewById<RecyclerView>(R.id.rv_filmes)
        val moviesList = movieRepository.getAllMovies()
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        moviesRecyclerView.adapter = MovieAdapter(moviesList)
    }
}