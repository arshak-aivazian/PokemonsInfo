package com.example.pokemonsinfo.ui.pokemonlist

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.ui.BaseActivity
import com.example.pokemonsinfo.ui.pokemondetails.PokemonDetailActivity
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import javax.inject.Inject
import javax.inject.Provider

class PokemonListActivity : BaseActivity(), PokemonListView {

    val adapter = PokemonsAdapter()

    @Inject
    lateinit var presenterProvider : Provider<PokemonListPresenter>

    @InjectPresenter
    lateinit var pokemonListPresenter: PokemonListPresenter

    @ProvidePresenter
    fun providePresenter() : PokemonListPresenter = presenterProvider.get()

    override val layoutId: Int = R.layout.activity_pokemon_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerViewPokemons.layoutManager = LinearLayoutManager(this)
        recyclerViewPokemons.adapter = adapter
        adapter.setListener(object : PokemonsAdapter.OnSelectedItem {
            override fun onClick(pokemon: Pokemon) {
                pokemonListPresenter.navigateToPokemonInfo(pokemon)
            }
        })
    }

    override fun showError(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun setupPokemonList(list: List<Pokemon>) {
        adapter.setupPokemons(list)
    }

    override fun showPokemonDetail(pokemon: Pokemon) {
        PokemonDetailActivity.startAcivity(this, pokemon)
    }
}
