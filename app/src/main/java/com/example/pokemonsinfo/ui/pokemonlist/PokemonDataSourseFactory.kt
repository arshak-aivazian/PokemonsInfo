package com.example.pokemonsinfo.ui.pokemonlist

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.repository.PokemonsRepository

class PokemonDataSourseFactory(private val repository: PokemonsRepository): DataSource.Factory<Int, Pokemon>() {

    val pokemonDataSourceLiveData = MutableLiveData<PokemonListDataSource>()

    override fun create(): DataSource<Int, Pokemon> {
        val pokemonDataSource = PokemonListDataSource(repository)
        pokemonDataSourceLiveData.postValue(pokemonDataSource)
        return pokemonDataSource
    }
}