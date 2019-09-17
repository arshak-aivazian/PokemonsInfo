package com.example.pokemonsinfo.ui.pokemondetail

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.pokemonsinfo.pojo.Pokemon

@InjectViewState
class PokemonDetailPresenter(private val pokemon: Pokemon): MvpPresenter<PokemonDetailView>(){
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showInfo(pokemon)
    }

}