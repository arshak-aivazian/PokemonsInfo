package com.example.pokemonsinfo.ui.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.repository.PokemonsRepositiryProvider

class PokemonListViewModel: ViewModel(){
    private val repositiry = PokemonsRepositiryProvider.providePokemonRepository()
    var pokemonList: LiveData<PagedList<Pokemon>>
    private val pokemonDataSourseFactory: PokemonDataSourseFactory

    init {
       pokemonDataSourseFactory = PokemonDataSourseFactory(repositiry)
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(30)
            .build();

        pokemonList = LivePagedListBuilder<Int, Pokemon>(pokemonDataSourseFactory, config)
            .build()
    }
}