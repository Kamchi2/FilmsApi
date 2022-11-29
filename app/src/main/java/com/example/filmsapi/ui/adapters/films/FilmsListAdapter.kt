package com.example.filmsapi.ui.adapters.films

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.filmsapi.base.BaseDiffUtilItemCallback
import com.example.filmsapi.databinding.ItemFilmBinding
import com.example.filmsapi.interfaces.OnItemClick
import com.example.filmsapi.models.FilmsModel


class FilmsListAdapter (private val onItemClick: OnItemClick ) :
    ListAdapter<FilmsModel, FilmsListAdapter.FilmsViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = FilmsViewHolder(
        ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    inner class FilmsViewHolder(private val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: FilmsModel) {
            binding.filmNameTv.text = model.title
            binding.filmRatingTv.text = model.rt_score
            binding.filmIconIv.load(model.image)
            binding.originalFilmNameTv.text = model.original_title

            itemView.setOnClickListener {
                onItemClick.onClick(model.id)
            }
        }
    }
}