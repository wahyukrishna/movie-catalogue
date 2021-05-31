package com.dicoding.mymoviecatalogue.utils

import com.dicoding.mymoviecatalogue.data.source.remote.response.*

object DataDummy {
    fun generateMovie(): List<ResultsItem> {
        val movies = ArrayList<ResultsItem>()

        movies.add(
            ResultsItem(
                578701,
                "Those Who Wish Me Dead",
                "2021-05-05",
                "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg"
            )
        )

        movies.add(
            ResultsItem(
                399566,
                "Godzilla vs. Kong",
                "2021-03-24",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            )
        )

        movies.add(
            ResultsItem(
                791373,
                "Zack Snyder's Justice League",
                "2021-03-18",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"
            )
        )

        return movies
    }

    fun generateTV(): List<TvItem> {
        val tvShow = ArrayList<TvItem>()

        tvShow.add(
            TvItem(
                93484,
                "Jupiter's Legacy",
                "2021-05-07",
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
            )
        )

        tvShow.add(
            TvItem(
                93741,
                "Jurassic World: Camp Cretaceous",
                "2020-09-18",
                "/uIkFnEDNG5CtwfuoPsWbdIAM2ln.jpg"
            )
        )

        tvShow.add(
            TvItem(
                62286,
                "Fear the Walking Dead",
                "2015-08-23",
                "/58PON1OrnBiX6CqEHgeWKVwrCn6.jpg"
            )
        )

        return tvShow
    }

    fun getMovieResponse(): List<ResultsItem> {
        return listOf(
            ResultsItem(
                578701,
                "Those Who Wish Me Dead",
                "2021-05-05",
                "/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg"
            ),
            ResultsItem(
                399566,
                "Godzilla vs. Kong",
                "2021-03-24",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            ),
            ResultsItem(
                791373,
                "Zack Snyder's Justice League",
                "2021-03-18",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg"
            )
        )
    }

    fun getTvShowResponse(): List<TvItem>{
        return listOf(
            TvItem(
                93484,
                "Jupiter's Legacy",
                "2021-05-07",
                "/9yxep7oJdkj3Pla9TD9gKflRApY.jpg"
            ),
            TvItem(
                93741,
                "Jurassic World: Camp Cretaceous",
                "2020-09-18",
                "/uIkFnEDNG5CtwfuoPsWbdIAM2ln.jpg"
            ),
            TvItem(
                62286,
                "Fear the Walking Dead",
                "2015-08-23",
                "/58PON1OrnBiX6CqEHgeWKVwrCn6.jpg"
            )

        )
    }

    fun getDetailMovieResponse(): MovieDetailResponse{
        return MovieDetailResponse(
            399566,
            "Godzilla vs. Kong",
            "2021-03-24",
            "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            113,
            8.1,
            "One Will Fall",
        )
    }

    fun getDetailTvResponse(): TvDetailResponse {
        return TvDetailResponse(
            62286,
            "Fear the Walking Dead",
            "2015-08-23",
            "/4UjiPdFKJGJYdxwRs2Rzg7EmWqr.jpg",
            "What did the world look like as it was transforming into the horrifying apocalypse depicted in \\\"The Walking Dead\\\"? This spin-off set in Los Angeles, following new characters as they face the beginning of the end of the world, will answer that question.",
            listOf(43),
            7.6,
            "Every decision is life or death.",
        )
    }
}