package com.dicoding.mymoviecatalogue.di

import android.content.Context
import com.dicoding.mymoviecatalogue.data.source.remote.MovieTVRepository
import com.dicoding.mymoviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): MovieTVRepository{
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieTVRepository.getInstance(remoteDataSource)
    }
}