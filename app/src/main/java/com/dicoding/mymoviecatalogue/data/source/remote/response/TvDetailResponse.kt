package com.dicoding.mymoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvDetailResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("first_air_date")
	val firstAirDate: String,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("episode_run_time")
	val runtime: List<Int>,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

	@field:SerializedName("tagline")
	val tagline: String,

)


