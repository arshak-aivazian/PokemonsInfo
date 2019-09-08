package com.example.pokemonsinfo.ui.pokemonlist

import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.repository.PokemonsRepository
import dagger.Module
import dagger.Provides

@Module
class PokemonListModule{

    @Provides
    fun providePresenter(repository: PokemonsRepository) : PokemonListPresenter = PokemonListPresenter(repository)

}