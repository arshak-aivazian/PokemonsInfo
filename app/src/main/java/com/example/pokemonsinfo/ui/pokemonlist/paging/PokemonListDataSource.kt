package com.example.pokemonsinfo.ui.pokemonlist

import androidx.paging.PageKeyedDataSource
import androidx.paging.PositionalDataSource
import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.repository.PokemonsRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PokemonListDataSource(private val repository: PokemonsRepository): PageKeyedDataSource<Int, Pokemon>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Pokemon>
    ) {
        repository.loadPokemonList()
            .flatMap { Observable.fromIterable(it.results) }
            .flatMap { repository.loadPokemonInfo(it.name) }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    response -> callback.onResult(response,null,30)
            }, {

            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {
        repository.loadPokemonList(offset = params.key)
            .flatMap { Observable.fromIterable(it.results) }
            .flatMap { repository.loadPokemonInfo(it.name) }
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    response -> callback.onResult(response,params.key+30)
            }, {

            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Pokemon>) {
    }
}