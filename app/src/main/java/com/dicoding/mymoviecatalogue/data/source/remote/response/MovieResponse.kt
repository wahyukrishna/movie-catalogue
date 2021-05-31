package com.dicoding.mymoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("results")
	val results: List<ResultsItem>,
)

data class ResultsItem(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("release_date")
	val releaseDate: String,

	@field:SerializedName("poster_path")
	val posterPath: String,
)


