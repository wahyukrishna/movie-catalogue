package com.dicoding.mymoviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.source.remote.MovieTVRepository
import com.dicoding.mymoviecatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvDetailResponse

class DetailMovieViewModel(private val movieTVRepository: MovieTVRepository) : ViewModel() {
    private var movieId: Int = 0

    fun setSelectedMovieTv(movieId: Int) {
        this.movieId = movieId
    }

    fun getMovie(movieId: Int): LiveData<MovieDetailResponse> = movieTVRepository.getMovieDetails(movieId)

    fun getTV(movieId: Int): LiveData<TvDetailResponse> = movieTVRepository.getTvDetails(movieId)

}