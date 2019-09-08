package com.example.pokemonsinfo.di

import com.example.pokemonsinfo.ui.pokemondetails.PokemonDetailActivity
import com.example.pokemonsinfo.ui.pokemondetails.PokemonDetailModule
import com.example.pokemonsinfo.ui.pokemonlist.PokemonListActivity
import com.example.pokemonsinfo.ui.pokemonlist.PokemonListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AcitivityBuilder{

    @ContributesAndroidInjector(modules = [PokemonDetailModule::class])
    abstract fun buildPokemonDetailActivity() : PokemonDetailActivity

    @ContributesAndroidInjector(modules = [PokemonListModule::class])
    abstract fun buildPokemonListActivity() : PokemonListActivity

}