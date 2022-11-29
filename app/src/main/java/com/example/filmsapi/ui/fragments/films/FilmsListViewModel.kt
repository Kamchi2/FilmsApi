package com.example.filmsapi.ui.fragments.films

import com.example.filmsapi.base.BaseViewModel
import com.example.filmsapi.data.repositorys.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsListViewModel @Inject constructor(private val repository: FilmsRepository) :
    BaseViewModel() {

    fun fetchFilms() = repository.fetchFilms()

}
