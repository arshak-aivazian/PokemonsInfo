package com.example.pokemonsinfo.ui.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.repository.PokemonsRepository
import com.example.pokemonsinfo.ui.views.PokemonListView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class PokemonListPresenter(private val repository: PokemonsRepository) : MvpPresenter<PokemonListView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repository.loadPokemonList(0,30)
            .flatMap { Observable.fromIterable(it.results) }
            .flatMap { repository.loadPokemonInfo(it.name) }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setupPokemonList(it)
            }, {
                viewState.showError(it.localizedMessage)
            })
    }

    fun navigateToPokemonInfo(pokemon: Pokemon){
        viewState.showPokemonDetail(pokemon)
    }
}