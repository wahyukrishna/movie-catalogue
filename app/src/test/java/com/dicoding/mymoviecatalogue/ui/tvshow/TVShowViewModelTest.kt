package com.dicoding.mymoviecatalogue.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TVShowViewModelTest {

    private lateinit var viewModel: TVShowViewModel

    @Before
    fun setUp(){
        viewModel = TVShowViewModel()
    }

    @Test
    fun getMovies() {
        val tvEntities = viewModel.getTVShow()
        assertNotNull(tvEntities)
        assertEquals(11, tvEntities.size)
    }
}