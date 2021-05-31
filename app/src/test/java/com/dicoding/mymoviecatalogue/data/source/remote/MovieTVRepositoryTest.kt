package com.dicoding.mymoviecatalogue.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.mymoviecatalogue.utils.DataDummy
import com.dicoding.mymoviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.doAnswer
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito

class MovieTVRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieTVRepository = FakeMovieTVRepository(remote)

    private val movieResponse = DataDummy.getMovieResponse()
    private val movieId = movieResponse[0].id
    private val movieDetail = DataDummy.getDetailMovieResponse()

    private val tvResponse = DataDummy.getTvShowResponse()
    private val tvId = tvResponse[0].id
    private val tvDetail = DataDummy.getDetailTvResponse()



    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.MovieCallback)
                .getMovies(movieResponse)
        null
        }.`when`(remote).getMovieList(any())
        val movieEntities = LiveDataTestUtil.getValue(movieTVRepository.getMovies())
        verify(remote).getMovieList(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponse.size.toLong(),movieEntities.size.toLong())
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.TvCallback)
                .getTvShows(tvResponse)
            null
        }.`when`(remote).getTvList(any())
        val tvEntities = LiveDataTestUtil.getValue(movieTVRepository.getTvShows())
        verify(remote).getTvList(any())
        assertNotNull(tvEntities)
        assertEquals(tvResponse.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getMovieDetails() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.MovieDetailCallback)
                .getMovieDetails(movieDetail)
            null
        }.`when`(remote).getMovieDetails(any(),eq(movieId))
        val movieDetailEntities = LiveDataTestUtil.getValue(movieTVRepository.getMovieDetails(movieId))
        verify(remote).getMovieDetails(any(), eq(movieId))
        assertNotNull(movieDetailEntities)
        assertEquals(movieDetail.id, movieDetailEntities.id)
    }

    @Test
    fun getTvDetails() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.TVDetailCallback)
                .getTvDetails(tvDetail)
            null
        }.`when`(remote).getTvDetails(any(), eq(tvId))
        val tvDetailEntities = LiveDataTestUtil.getValue(movieTVRepository.getTvDetails(tvId))
        verify(remote).getTvDetails(any(), eq(tvId))
        assertNotNull(tvDetailEntities)
        assertEquals(tvDetail.id, tvDetailEntities.id)
    }
}