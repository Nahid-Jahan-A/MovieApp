package com.example.movieapp.movieList.data.repository

import com.example.movieapp.movieList.data.local.movie.MovieDatabase
import com.example.movieapp.movieList.data.remote.MovieApi
import com.example.movieapp.movieList.domain.model.Movie
import com.example.movieapp.movieList.domain.repository.MovieListRepository
import com.example.movieapp.movieList.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieListRepositoryImpl @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
)
    : MovieListRepository{
    override suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        category: String,
        page: Int
    ): Flow<Resource<List<Movie>>> {
        return flow {
            emit(Resource.Loading(true))

            val localMovieList = movieDatabase.movieDao.getMovieByCategory(category)

            val shouldLoadLocal = localMovieList.isEmpty() && !forceFetchFromRemote

            if(shouldLoadLocal) {
                emit(Resource.Success(
                    data = localMovieList
                ))
            }
        }
    }

    override suspend fun getMovie(id: Int): Flow<Resource<Movie>> {
        TODO("Not yet implemented")
    }

}