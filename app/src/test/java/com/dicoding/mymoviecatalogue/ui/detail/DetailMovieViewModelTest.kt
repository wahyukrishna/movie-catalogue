package com.dicoding.mymoviecatalogue.ui.detail

import com.dicoding.mymoviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailMovieViewModelTest {

    private lateinit var  viewModel: DetailMovieViewModel
    private lateinit var  viewModelTV: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val dummyTVShow = DataDummy.generateDummyTV()[0]
    private val movieId = dummyMovie.movieId
    private val tvId = dummyTVShow.movieId

    @Before
    fun setUp(){
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModelTV = DetailMovieViewModel()
        viewModelTV.setSelectedMovie(tvId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.year, movieEntity.year)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.imagePath, movieEntity.imagePath)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.director, movieEntity.director)
        assertEquals(dummyMovie.castLink, movieEntity.castLink)
        assertEquals(dummyMovie.videoId, movieEntity.videoId)

    }

    @Test
    fun getTV() {
        viewModelTV.setSelectedMovie(dummyTVShow.movieId)
        val tvEntity = viewModelTV.getTV()
        assertNotNull(tvEntity)
        assertEquals(dummyTVShow.movieId, tvEntity.movieId)
        assertEquals(dummyTVShow.year, tvEntity.year)
        assertEquals(dummyTVShow.description, tvEntity.description)
        assertEquals(dummyTVShow.imagePath, tvEntity.imagePath)
        assertEquals(dummyTVShow.title, tvEntity.title)
        assertEquals(dummyTVShow.rating, tvEntity.rating)
        assertEquals(dummyTVShow.director, tvEntity.director)
        assertEquals(dummyTVShow.castLink, tvEntity.castLink)
        assertEquals(dummyTVShow.videoId, tvEntity.videoId)
    }
}