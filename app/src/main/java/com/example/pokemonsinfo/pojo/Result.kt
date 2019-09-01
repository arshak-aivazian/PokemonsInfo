package com.example.pokemonsinfo.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Result(
    @field: SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String?
)