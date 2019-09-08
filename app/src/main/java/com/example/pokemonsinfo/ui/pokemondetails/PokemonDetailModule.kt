package com.example.pokemonsinfo.ui.pokemondetails

import com.example.pokemonsinfo.pojo.Pokemon
import dagger.Module
import dagger.Provides

@Module
class PokemonDetailModule{

    @Provides
    fun providePresenter(pokemon: Pokemon) : PokemonDetailPresenter = PokemonDetailPresenter(pokemon)

    @Provides
    fun providePokemon(activity: PokemonDetailActivity) : Pokemon = activity.getPokemon()

}