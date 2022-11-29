package com.example.filmsapi.ui.fragments.films.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.filmsapi.R
import com.example.filmsapi.base.BaseFragment
import com.example.filmsapi.databinding.FragmentFilmsDetailListBinding
import com.example.filmsapi.models.FilmsModel
import com.example.filmsapi.ui.fragments.films.FilmsListFragmentDirections
import com.example.filmsapi.ui.fragments.films.FilmsListViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FilmsDetailListFragment :
    BaseFragment<FragmentFilmsDetailListBinding, FilmsDetailListViewModel>(R.layout.fragment_films_detail_list) {

    override val binding by viewBinding(FragmentFilmsDetailListBinding::bind)
    override val viewModel: FilmsDetailListViewModel by viewModels()
    private val saveArgs: FilmsDetailListFragmentArgs by navArgs()

    override fun setupSubscribe() {
        viewModel.fetchDetailFilms(saveArgs.id).subscribe(
            onSuccess = {
                binding.filmIconIv.load(it.image)
                binding.filmNameTv.text = it.title
                binding.filmDescriptionTv.text = it.description
                binding.producerNameTv.text = it.producer
                binding.runningTimeTv.text = it.running_time
                binding.directorNameTv.text = it.director
                binding.releaseDateTv.text = it.release_date
                binding.exitBtn.setOnClickListener {
                    findNavController().navigate(
                        FilmsDetailListFragmentDirections.actionFilmDetailFragmentToFilmFragment()
                    )
                }
            },
            onError = {
                Log.e("film", it)
            }
        )
    }
}