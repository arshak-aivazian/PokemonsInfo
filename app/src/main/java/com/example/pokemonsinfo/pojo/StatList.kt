package com.example.pokemonsinfo.pojo

import com.google.gson.annotations.SerializedName

data class StatList(
    @field: SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("stat")
    val stat: PokemonStat
)


