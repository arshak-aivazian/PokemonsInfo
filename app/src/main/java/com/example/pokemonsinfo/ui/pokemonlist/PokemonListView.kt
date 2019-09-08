package com.example.pokemonsinfo.ui.pokemonlist

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.pokemonsinfo.pojo.Pokemon

@StateStrategyType(AddToEndSingleStrategy::class)
interface PokemonListView: MvpView{
    fun showError(text: String)
    fun setupPokemonList(list: List<Pokemon>)
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun showPokemonDetail(pokemon: Pokemon)
}