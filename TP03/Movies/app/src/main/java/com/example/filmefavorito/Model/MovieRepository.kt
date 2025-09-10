package com.example.filmefavorito.Model

interface MovieRepository {
    fun addMovie(movie: Movie)
    fun getAllMovies(): List<Movie>
}
