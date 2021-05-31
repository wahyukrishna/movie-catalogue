package com.dicoding.mymoviecatalogue.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.mymoviecatalogue.R
import com.dicoding.mymoviecatalogue.data.source.Source
import com.dicoding.mymoviecatalogue.data.source.remote.response.MovieDetailResponse
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvDetailResponse
import com.dicoding.mymoviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.mymoviecatalogue.databinding.ContentDetailMovieBinding
import com.dicoding.mymoviecatalogue.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TV = "extra_tv"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)
        setSupportActionBar(activityDetailMovieBinding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(
            this, factory
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)
            val tvId = extras.getInt(EXTRA_TV,0)
            if (movieId != 0) {
                viewModel.setSelectedMovieTv(movieId)
                viewModel.getMovie(movieId).observe(this, {movie ->
                    populateMovie(movie)
                })
                supportActionBar?.title = "Movie Details"
            }
            if (tvId != 0) {
                viewModel.setSelectedMovieTv(tvId)
                viewModel.getTV(tvId).observe(this, {tv ->
                    populateTv(tv)
                })
                supportActionBar?.title = "TV Show Details"
            }
        }

    }

    private fun populateMovie(movieEntity: MovieDetailResponse) {
        detailContentBinding.apply {
            val runtime = movieEntity.runtime.toString() + " Minutes"
            val imageSource= Source.POSTER_URL+movieEntity.posterPath
            textTitle.text = movieEntity.title
            textDescription.text = movieEntity.overview
            textRuntime.text = runtime
            textYear.text = movieEntity.releaseDate
            textTagline.text = movieEntity.tagline
            ratingBar.rating = movieEntity.voteAverage.toFloat()/2

            Glide.with(this@DetailMovieActivity)
                .load(imageSource)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
        }


    }

    private fun populateTv(movieEntity: TvDetailResponse) {
        detailContentBinding.apply {
            val runtime = movieEntity.runtime[0].toString() + " Minutes/Episode"
            textTitle.text = movieEntity.name
            textDescription.text = movieEntity.overview
            textYear.text = movieEntity.firstAirDate
            textRuntime.text = runtime
            textTagline.text = movieEntity.tagline
            ratingBar.rating = movieEntity.voteAverage.toFloat()/2

            Glide.with(this@DetailMovieActivity)
                .load(Source.POSTER_URL+movieEntity.posterPath)
                .transform(RoundedCorners(20))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
        }

    }

}