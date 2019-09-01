package com.example.pokemonsinfo.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonStat(
    @field: SerializedName("name")
    val name: String
) : Serializable
