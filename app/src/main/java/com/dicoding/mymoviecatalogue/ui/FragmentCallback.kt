package com.dicoding.mymoviecatalogue.ui

import com.dicoding.mymoviecatalogue.data.source.remote.response.ResultsItem
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvItem

interface FragmentCallback {
    fun onShareClick(movie: ResultsItem)

}

interface FragmentTvCallback{
    fun onShareClick(tv: TvItem)
}
