package com.example.pokemonsinfo.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class PokemonType(
    @field: SerializedName("name")
    val name: String
): Serializable
