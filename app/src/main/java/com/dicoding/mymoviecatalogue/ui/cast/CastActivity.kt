package com.dicoding.mymoviecatalogue.ui.cast

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.mymoviecatalogue.databinding.ActivityCastBinding

class CastActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE_ID = "extra_movie"
    }

    private lateinit var binding: ActivityCastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val link = intent.getStringExtra(EXTRA_MOVIE_ID)


        val myWebView: WebView = binding.webView
        myWebView.loadUrl(link.toString())

        supportActionBar?.hide()
    }
}