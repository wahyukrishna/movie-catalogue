package com.dicoding.mymoviecatalogue.ui

import com.dicoding.mymoviecatalogue.data.MovieEntity

interface FragmentCallback {
    fun onShareClick(movie: MovieEntity)
}
