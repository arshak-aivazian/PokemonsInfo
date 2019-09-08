package com.example.pokemonsinfo.repository

import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.pojo.PokemonListResponse
import io.reactivex.Observable

interface PokemonsRepository{
    fun loadPokemonList(offset: Int, limit: Int): Observable<PokemonListResponse>
    fun loadPokemonInfo(name: String): Observable<Pokemon>
}