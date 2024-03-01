package com.example.movieapp.movieList.data.mappers

import com.example.movieapp.movieList.data.local.movie.MovieEntity
import com.example.movieapp.movieList.domain.model.Movie

fun MovieEntity.toMovie(
    category: String
) : Movie {
    return Movie(
        backdrop_path = backdrop_path,
        original_title = original_title,
        original_language = original_language,
        overview = overview,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        vote_average = vote_average,
        popularity = popularity,
        vote_count = vote_count,
        video = video,
        id = id,
        adult = adult,

        category = category,
        genre_ids = try {
            genre_ids.spliterator().trySplit()
        }
    )
}