package com.dicoding.mymoviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.MovieEntity
import com.dicoding.mymoviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
}