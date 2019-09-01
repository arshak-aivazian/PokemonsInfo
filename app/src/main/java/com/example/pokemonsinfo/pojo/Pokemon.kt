package com.example.pokemonsinfo.pojo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Pokemon(
    @field:SerializedName("id")
    val id: Int,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("height")
    val height: Int,
    @field:SerializedName("weight")
    val weight: Int,
    @field:SerializedName("stats")
    val stats: List<StatList>,
    @field:SerializedName("types")
    val types: List<TypeList>,
    @field:SerializedName("sprites")
    val sprites: PokemonSprites
): Serializable