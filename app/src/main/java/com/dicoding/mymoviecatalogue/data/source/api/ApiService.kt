package com.dicoding.mymoviecatalogue.data.source.api

import com.dicoding.mymoviecatalogue.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String
    ):Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovies(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String
    ):Call<MovieDetailResponse>

    @GET("tv/popular")
    fun getTVShows(
        @Query("api_key") apiKey: String
    ):Call<TVResponse>

    @GET("tv/{tv_id}")
    fun getDetailTvShows(
        @Path("tv_id") id: Int,
        @Query("api_key") apiKey: String
    ):Call<TvDetailResponse>
}