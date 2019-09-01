package com.example.pokemonsinfo.ui.views

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.pokemonsinfo.pojo.Pokemon

@StateStrategyType(AddToEndSingleStrategy::class)
interface PokemonDetailView:MvpView{
    fun showInfo(pokemon: Pokemon)
}