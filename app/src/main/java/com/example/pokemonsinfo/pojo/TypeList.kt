package com.example.pokemonsinfo.pojo

import com.google.gson.annotations.SerializedName

data class TypeList(
    @field: SerializedName("slot")
    val slot: Int,
    @field: SerializedName("type")
    val type: PokemonType
)
