package com.dicoding.mymoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TVResponse(
    @field:SerializedName("results")
    val results: List<TvItem>,
)

data class TvItem(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val title: String,

    @field:SerializedName("first_air_date")
    val releaseDate: String,

    @field:SerializedName("poster_path")
    val posterPath: String,
)
