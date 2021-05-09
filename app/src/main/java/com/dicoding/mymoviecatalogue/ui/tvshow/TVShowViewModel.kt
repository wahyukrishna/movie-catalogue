package com.dicoding.mymoviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.dicoding.mymoviecatalogue.data.MovieEntity
import com.dicoding.mymoviecatalogue.utils.DataDummy

class TVShowViewModel: ViewModel() {
    fun getTVShow(): List<MovieEntity> = DataDummy.generateDummyTV()
}