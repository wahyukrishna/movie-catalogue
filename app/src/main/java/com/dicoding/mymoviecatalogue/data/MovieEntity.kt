package com.dicoding.mymoviecatalogue.data

data class MovieEntity(
    var movieId: String,
    var title: String,
    var rating: Int,
    var description: String,
    var year: String,
    var director: String,
    var castLink: String,
    var videoId: String,
    var imagePath: Int
)
