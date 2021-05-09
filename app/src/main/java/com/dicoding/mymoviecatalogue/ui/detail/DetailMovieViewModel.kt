package com.dicoding.mymoviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.MovieEntity
import com.dicoding.mymoviecatalogue.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val moviesEntity = DataDummy.generateDummyMovie()
        for (movieEntity in moviesEntity) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

    fun getTV(): MovieEntity {
        lateinit var movie: MovieEntity
        val moviesEntity = DataDummy.generateDummyTV()
        for (movieEntity in moviesEntity) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

}