package com.dicoding.mymoviecatalogue.ui.detail

import android.graphics.Movie
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.mymoviecatalogue.data.source.remote.MovieTVRepository
import com.dicoding.mymoviecatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.mymoviecatalogue.data.source.remote.response.ResultsItem
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvDetailResponse
import com.dicoding.mymoviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var  viewModel: DetailMovieViewModel
    private lateinit var  viewModelTv: DetailMovieViewModel
    private val dummyMovie = DataDummy.getDetailMovieResponse()
    private val dummyTVShow = DataDummy.getDetailTvResponse()
    private val movieId = dummyMovie.id
    private val tvId = dummyTVShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTVRepository: MovieTVRepository

    @Mock
    private lateinit var movieObserver: Observer<MovieDetailResponse>

    @Mock
    private lateinit var tvObserver: Observer<TvDetailResponse>

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel(movieTVRepository)
        viewModel.setSelectedMovieTv(movieId)
        viewModelTv = DetailMovieViewModel(movieTVRepository)
        viewModelTv.setSelectedMovieTv(tvId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieDetailResponse>()
        movie.value = dummyMovie

        `when`(movieId.let{movieTVRepository.getMovieDetails(it)}).thenReturn(movie)
        val movieEntity = movieId.let{viewModel.getMovie(it).value} as MovieDetailResponse

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.voteAverage, movieEntity.voteAverage, 0.1)
        assertEquals(dummyMovie.tagline, movieEntity.tagline)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)

        viewModel.getMovie(movieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTV() {
        val tv = MutableLiveData<TvDetailResponse>()
        tv.value = dummyTVShow

        `when`(tvId.let{movieTVRepository.getTvDetails(it)}).thenReturn(tv)
        val tvEntity = tvId.let{viewModelTv.getTV(it).value} as TvDetailResponse

        assertNotNull(tvEntity)
        assertEquals(dummyTVShow.id, tvEntity.id)
        assertEquals(dummyTVShow.name, tvEntity.name)
        assertEquals(dummyTVShow.overview, tvEntity.overview)
        assertEquals(dummyTVShow.posterPath, tvEntity.posterPath)
        assertEquals(dummyTVShow.firstAirDate, tvEntity.firstAirDate)
        assertEquals(dummyTVShow.voteAverage, tvEntity.voteAverage, 0.1)
        assertEquals(dummyTVShow.tagline, tvEntity.tagline)
        assertEquals(dummyTVShow.runtime, tvEntity.runtime)

        viewModel.getTV(tvId).observeForever(tvObserver)
        verify(tvObserver).onChanged(dummyTVShow)
    }
}