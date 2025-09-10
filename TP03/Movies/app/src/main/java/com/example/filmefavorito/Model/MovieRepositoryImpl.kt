package com.example.filmefavorito.Model

class MovieRepositoryImpl : MovieRepository {
    companion object {
        private val movies = mutableListOf<Movie>()
    }

    override fun addMovie(movie: Movie) {
        movies.add(movie)
    }

    override fun getAllMovies(): List<Movie> {
        return movies
    }
}
