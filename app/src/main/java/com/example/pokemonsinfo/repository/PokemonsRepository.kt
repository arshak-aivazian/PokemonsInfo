package com.example.pokemonsinfo.repository

import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.pojo.PokemonListResponse
import io.reactivex.Observable

class PokemonsRepository(private val apiService: ApiService) {
    fun loadPokemonList(offset: Int = 0, limit: Int = 30): Observable<PokemonListResponse> {
        return apiService.getPokemonList(offset, limit)
    }
    fun loadPokemonInfo(name: String): Observable<Pokemon> {
        return apiService.getPokemonInfo(name)
    }
}