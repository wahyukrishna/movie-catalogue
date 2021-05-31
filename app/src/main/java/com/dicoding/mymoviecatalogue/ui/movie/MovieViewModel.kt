package com.dicoding.mymoviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.source.remote.MovieTVRepository
import com.dicoding.mymoviecatalogue.data.source.remote.response.ResultsItem

class MovieViewModel(private val movieTVRespository: MovieTVRepository) : ViewModel() {
    fun getMovies(): LiveData<List<ResultsItem>> = movieTVRespository.getMovies()
}