package com.example.pokemonsinfo.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.repository.PokemonsRepositiryProvider
import com.example.pokemonsinfo.ui.adapters.PokemonsAdapter
import com.example.pokemonsinfo.ui.presenters.PokemonListPresenter
import com.example.pokemonsinfo.ui.views.PokemonListView
import kotlinx.android.synthetic.main.activity_pokemon_list.*

class PokemonListActivity : MvpAppCompatActivity(), PokemonListView {

    val adapter = PokemonsAdapter()

    @InjectPresenter
    lateinit var pokemonListPresenter: PokemonListPresenter

    @ProvidePresenter
    fun providePresenter() : PokemonListPresenter {
        val repositiry = PokemonsRepositiryProvider.providePokemonRepository()
        return PokemonListPresenter(repositiry)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

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
