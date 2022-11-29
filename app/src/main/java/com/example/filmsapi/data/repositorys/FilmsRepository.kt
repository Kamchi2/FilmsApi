package com.example.filmsapi.data.repositorys

import com.example.filmsapi.base.BaseRepository
import com.example.filmsapi.data.remote.apiservices.films.FilmsApiService
import javax.inject.Inject

class FilmsRepository @Inject constructor(private val service: FilmsApiService): BaseRepository() {

    fun fetchFilms() = doRequest {
        service.fetchFilms()
    }

    fun fetchDetailFilms(id: String) = doRequest {
        service.fetchDetailFilm(id)
    }

}