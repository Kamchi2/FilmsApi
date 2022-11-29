package com.example.filmsapi.models

import com.example.filmsapi.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FilmsModel(
    override val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("original_title")
    val original_title: String,
    @SerializedName("original_title_romanised")
    val original_title_romanised: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("running_time")
    val running_time: String,
    @SerializedName("rt_score")
    val rt_score: String,
    @SerializedName("image")
    val image: String
) : IBaseDiffModel<String>