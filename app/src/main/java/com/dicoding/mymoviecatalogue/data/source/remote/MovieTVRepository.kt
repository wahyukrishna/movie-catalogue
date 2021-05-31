package com.dicoding.mymoviecatalogue.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.mymoviecatalogue.data.source.remote.response.*

class MovieTVRepository private constructor(private val remoteDataSource: RemoteDataSource): MovieTVDataSource {
    companion object{
        @Volatile
        private var instance: MovieTVRepository? = null

        fun getInstance(remoteData: RemoteDataSource): MovieTVRepository =
            instance ?: synchronized(this){
                instance ?: MovieTVRepository(remoteData).apply{ instance = this}
            }
    }

    override fun getMovies(): LiveData<List<ResultsItem>> {
        val moviesRes = MutableLiveData<List<ResultsItem>>()
        remoteDataSource.getMovieList(callback = object : RemoteDataSource.MovieCallback {
            override fun getMovies(movie: List<ResultsItem>?) {
                val movieList = ArrayList<ResultsItem>()
                if(movie != null){
                    for (i in movie) {
                        val movies = i.let {movieData ->
                            ResultsItem(
                                movieData.id,
                                movieData.title,
                                movieData.releaseDate,
                                movieData.posterPath
                            )
                        }
                        movieList.add(movies)
                    }
                }
                moviesRes.postValue(movieList)
            }
        })
        return moviesRes
    }

    override fun getTvShows(): LiveData<List<TvItem>> {
        val tvRes = MutableLiveData<List<TvItem>>()
        remoteDataSource.getTvList(callback = object : RemoteDataSource.TvCallback {
            override fun getTvShows(tv: List<TvItem>?) {
                val tvList = ArrayList<TvItem>()
                if(tv != null){
                    for (i in tv) {
                        val tvItem = i.let {movieData ->
                            TvItem(
                                movieData.id,
                                movieData.title,
                                movieData.releaseDate,
                                movieData.posterPath
                            )
                        }
                        tvList.add(tvItem)
                    }
                }
                tvRes.postValue(tvList)
            }
        })
        return tvRes
    }



    override fun getMovieDetails(id: Int): LiveData<MovieDetailResponse> {
        val movieId = MutableLiveData<MovieDetailResponse>()
        remoteDataSource.getMovieDetails(object : RemoteDataSource.MovieDetailCallback{
            override fun getMovieDetails(movieDetail: MovieDetailResponse) {
                val movie = movieDetail.let { movieData ->
                    MovieDetailResponse(
                        movieData.id,
                        movieData.title,
                        movieData.releaseDate,
                        movieData.posterPath,
                        movieData.overview,
                        movieData.runtime,
                        movieData.voteAverage,
                        movieData.tagline
                    )
                }
                movieId.postValue(movie)
            }
        },id)
        return  movieId
    }

    override fun getTvDetails(id: Int): LiveData<TvDetailResponse> {
        val tvId = MutableLiveData<TvDetailResponse>()
        remoteDataSource.getTvDetails(object : RemoteDataSource.TVDetailCallback{
            override fun getTvDetails(tvDetail: TvDetailResponse) {
                val tv = tvDetail.let { tvData ->
                    TvDetailResponse(
                        tvData.id,
                        tvData.name,
                        tvData.firstAirDate,
                        tvData.posterPath,
                        tvData.overview,
                        tvData.runtime,
                        tvData.voteAverage,
                        tvData.tagline
                    )
                }
                tvId.postValue(tv)
            }
        },id)
        return tvId
    }


}