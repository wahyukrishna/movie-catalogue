package com.dicoding.mymoviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.mymoviecatalogue.R
import com.dicoding.mymoviecatalogue.data.source.remote.response.TvItem
import com.dicoding.mymoviecatalogue.databinding.FragmentTvShowBinding
import com.dicoding.mymoviecatalogue.ui.FragmentTvCallback
import com.dicoding.mymoviecatalogue.viewmodel.ViewModelFactory

class TVShowFragment : Fragment(), FragmentTvCallback {


    private lateinit var fragmentTvBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvBinding = FragmentTvShowBinding.inflate(inflater, container, false)
        return  fragmentTvBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel =  ViewModelProvider(this, factory)[TVShowViewModel::class.java]

        val tvAdapter = TVShowAdapter(this)

        viewModel.getTv().observe(viewLifecycleOwner, { movie ->
            if(movie != null){
                tvAdapter.setMovies(movie)
                tvAdapter.notifyDataSetChanged()
            }
        })

            with(fragmentTvBinding.rvTv) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvAdapter
            }


    }

    override fun onShareClick(tv: TvItem) {
        if(activity != null){
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                    .from(requireActivity())
                    .setType(mimeType)
                    .setChooserTitle("Bagikan aplikasi ini sekarang.")
                    .setText(resources.getString(R.string.share_text, tv.title))
                    .startChooser()
        }
    }

}