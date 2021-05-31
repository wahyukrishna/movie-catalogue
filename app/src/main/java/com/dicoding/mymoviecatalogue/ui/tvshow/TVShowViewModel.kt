package com.dicoding.mymoviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.source.remote.MovieTVRepository
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvItem

class TVShowViewModel(private val movieTVRespository: MovieTVRepository): ViewModel() {
    fun getTv(): LiveData<List<TvItem>> = movieTVRespository.getTvShows()
}