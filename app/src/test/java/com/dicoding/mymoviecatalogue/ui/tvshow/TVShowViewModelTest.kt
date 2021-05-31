package com.dicoding.mymoviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.mymoviecatalogue.data.source.remote.MovieTVRepository
import com.dicoding.mymoviecatalogue.data.source.remote.response.ResultsItem
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvItem
import com.dicoding.mymoviecatalogue.ui.movie.MovieViewModel
import com.dicoding.mymoviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieTVRepository: MovieTVRepository

    @Mock
    private lateinit var observer: Observer<List<TvItem>>

    @Before
    fun setUp(){
        viewModel = TVShowViewModel(movieTVRepository)
    }

    @Test
    fun getMovies() {
        val dummyTv = DataDummy.generateTV()
        val tv = MutableLiveData<List<TvItem>>()
        tv.value = dummyTv

        Mockito.`when`(movieTVRepository.getTvShows()).thenReturn(tv)
        val tvEntities = viewModel.getTv().value
        verify(movieTVRepository).getTvShows()
        assertNotNull(tvEntities)
        assertEquals(3, tvEntities?.size)

        viewModel.getTv().observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }
}