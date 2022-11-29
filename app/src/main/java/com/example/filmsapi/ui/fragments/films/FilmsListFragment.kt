package com.example.filmsapi.ui.fragments.films

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.filmsapi.R
import com.example.filmsapi.base.BaseFragment
import com.example.filmsapi.databinding.FragmentFilmsDetailListBinding
import com.example.filmsapi.databinding.FragmentFilmsListBinding
import com.example.filmsapi.interfaces.OnItemClick
import com.example.filmsapi.models.FilmsModel
import com.example.filmsapi.ui.adapters.films.FilmsListAdapter
import com.example.filmsapi.ui.fragments.films.detail.FilmsDetailListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsListFragment :
    BaseFragment<FragmentFilmsListBinding, FilmsListViewModel>(R.layout.fragment_films_list), OnItemClick {

    override val binding by viewBinding(FragmentFilmsListBinding::bind)
    override val viewModel: FilmsListViewModel by viewModels()
    private val filmsAdapter = FilmsListAdapter(this)

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        viewModel.fetchFilms().subscribe(
            onSuccess = {
                filmsAdapter.submitList(it)
            },
            onError = {
                Log.e("log", it )
            }
        )
    }

    private fun setupRecyclerView() {
        binding.filmslistRv.adapter = filmsAdapter
    }

    override fun onClick(id: String) {
        findNavController().navigate(
            FilmsListFragmentDirections.actionFilmFragmentToDetailFilmFragment(id)
        )
    }
}