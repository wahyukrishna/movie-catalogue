package com.dicoding.mymoviecatalogue.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.mymoviecatalogue.R
import com.dicoding.mymoviecatalogue.data.MovieEntity
import com.dicoding.mymoviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.mymoviecatalogue.databinding.ContentDetailMovieBinding
import com.dicoding.mymoviecatalogue.ui.cast.CastActivity
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

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

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            val tvId = extras.getString(EXTRA_TV)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie())
                supportActionBar?.title = "Movie Details"
            }
            if (tvId != null) {
                viewModel.setSelectedMovie(tvId)
                populateMovie(viewModel.getTV())
                supportActionBar?.title = "TV Show Details"
            }
        }

    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.textTitle.text = movieEntity.title
        detailContentBinding.textDescription.text = movieEntity.description
        detailContentBinding.textYear.text = movieEntity.year
        detailContentBinding.ratingBar.numStars = movieEntity.rating
        detailContentBinding.textDirector.text = movieEntity.director

        Glide.with(this)
            .load(movieEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentBinding.imagePoster)

        val ytplayer = detailContentBinding.videoView
        val videoId = movieEntity.videoId

        lifecycle.addObserver(ytplayer)
        ytplayer.getPlayerUiController()
        ytplayer.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0F)
            }
        })

        detailContentBinding.btnView.setOnClickListener {
            val intent = Intent(this@DetailMovieActivity, CastActivity::class.java)
            intent.putExtra(CastActivity.EXTRA_MOVIE_ID, movieEntity.castLink)
            startActivity(intent)
        }
    }

}