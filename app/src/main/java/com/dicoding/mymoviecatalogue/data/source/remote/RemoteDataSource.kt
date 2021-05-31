package com.dicoding.mymoviecatalogue.data.source.remote

import android.util.Log
import com.dicoding.mymoviecatalogue.data.source.Source.Companion.API_KEY
import com.dicoding.mymoviecatalogue.data.source.api.ApiConfig
import com.dicoding.mymoviecatalogue.data.source.remote.response.*
import com.dicoding.mymoviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object{
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this){
                instance ?: RemoteDataSource()
            }
    }

    fun getMovieList(callback: MovieCallback){
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getMovies(API_KEY)
            client.enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    callback.getMovies(response.body()?.results)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "failed to get movie list : ${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTvList(callback: TvCallback){
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getTVShows(API_KEY)
        client.enqueue(object : Callback<TVResponse> {
            override fun onResponse(
                call: Call<TVResponse>,
                response: Response<TVResponse>
            ) {
                callback.getTvShows(response.body()?.results)
                EspressoIdlingResource.decrement()
            }
            override fun onFailure(call: Call<TVResponse>, t: Throwable) {
                Log.d(this@RemoteDataSource.toString(), "failed to get tv show list : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getMovieDetails(callback: MovieDetailCallback, id: Int){
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailMovies(id, API_KEY)
            client.enqueue(object : Callback<MovieDetailResponse>{
                override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                    response.body()?.let{callback.getMovieDetails(it)}
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.d(this@RemoteDataSource.toString(), "failed to get movie details : ${t.message}")
                    EspressoIdlingResource.decrement()
                }
            })
    }

    fun getTvDetails(callback: TVDetailCallback, id: Int){
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailTvShows(id, API_KEY)
        client.enqueue(object : Callback<TvDetailResponse>{
            override fun onResponse(call: Call<TvDetailResponse>, response: Response<TvDetailResponse>) {
                response.body()?.let{callback.getTvDetails(it)}
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                Log.d(this@RemoteDataSource.toString(), "failed to get tv show details : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface MovieDetailCallback {
        fun getMovieDetails(movieDetail: MovieDetailResponse)
    }

    interface TVDetailCallback {
        fun getTvDetails(tvDetail: TvDetailResponse)
    }

    interface MovieCallback {
        fun getMovies(movie: List<ResultsItem>?)
    }

    interface TvCallback {
        fun getTvShows(tv: List<TvItem>?)
    }
}