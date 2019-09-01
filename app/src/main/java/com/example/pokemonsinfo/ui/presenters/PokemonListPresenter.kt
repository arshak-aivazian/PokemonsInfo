package com.example.pokemonsinfo.ui.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.pokemonsinfo.repository.ApiService
import com.example.pokemonsinfo.repository.PokemonsRepository
import com.example.pokemonsinfo.ui.views.PokemonListView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class PokemonListPresenter(repository: PokemonsRepository) : MvpPresenter<PokemonListView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        val service = ApiService.create()
        service.getPokemonList(0, 30)
            .flatMap { Observable.fromIterable(it.results) }
            .flatMap { service.getPokemonInfo(it.name) }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setupPokemonList(it)
            }, {
                viewState.showError(it.localizedMessage)
            })
    }
}