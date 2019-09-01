package com.example.pokemonsinfo.repository

object PokemonsRepositiryProvider{
    fun providePokemonRepository(): PokemonsRepository {
        return PokemonsRepository(ApiService.create())
    }
}