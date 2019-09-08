package com.example.pokemonsinfo.repository.impl

import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.pojo.PokemonListResponse
import com.example.pokemonsinfo.repository.ApiService
import com.example.pokemonsinfo.repository.PokemonsRepository
import io.reactivex.Observable

class PokemonsRepositoryImpl(private val apiService: ApiService) : PokemonsRepository{
    override fun loadPokemonList(offset: Int, limit: Int): Observable<PokemonListResponse> {
        return apiService.getPokemonList(offset, limit)
    }
    override fun loadPokemonInfo(name: String): Observable<Pokemon> {
        return apiService.getPokemonInfo(name)
    }
}