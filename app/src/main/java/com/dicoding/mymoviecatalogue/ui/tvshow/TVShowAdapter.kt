package com.dicoding.mymoviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.mymoviecatalogue.R
import com.dicoding.mymoviecatalogue.data.source.Source
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvItem
import com.dicoding.mymoviecatalogue.databinding.ItemsTvBinding
import com.dicoding.mymoviecatalogue.ui.FragmentTvCallback
import com.dicoding.mymoviecatalogue.ui.detail.DetailMovieActivity

class TVShowAdapter(private val callback: FragmentTvCallback) : RecyclerView.Adapter<TVShowAdapter.MovieViewHolder>() {
    private val listMovies = ArrayList<TvItem>()

    fun setMovies(movies: List<TvItem>?){
        if(movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsTvBinding = ItemsTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsTvBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size

    inner class MovieViewHolder(private val binding: ItemsTvBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: TvItem){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemYear.text = movie.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_TV, movie.id)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(movie) }
                Glide.with(itemView.context)
                        .load(Source.POSTER_URL + movie.posterPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}