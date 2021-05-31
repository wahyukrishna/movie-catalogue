package com.dicoding.mymoviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import com.dicoding.mymoviecatalogue.data.source.remote.response.*


interface MovieTVDataSource {

    fun getMovies(): LiveData<List<ResultsItem>>

    fun getTvShows(): LiveData<List<TvItem>>

    fun getMovieDetails(id: Int): LiveData<MovieDetailResponse>

    fun getTvDetails(id: Int): LiveData<TvDetailResponse>
}