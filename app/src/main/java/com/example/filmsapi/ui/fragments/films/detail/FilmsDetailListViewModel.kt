package com.example.filmsapi.ui.fragments.films.detail

import com.example.filmsapi.base.BaseViewModel
import com.example.filmsapi.data.repositorys.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsDetailListViewModel @Inject constructor(private val repository: FilmsRepository) :
    BaseViewModel() {

    fun fetchDetailFilms(filmId: String) = repository.fetchDetailFilms(filmId)

}
