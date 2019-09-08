package com.example.pokemonsinfo.ui.pokemondetails

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.ui.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_detail.*
import javax.inject.Inject
import javax.inject.Provider

class PokemonDetailActivity : BaseActivity(), PokemonDetailView {

    companion object{
        val KEY_POKEMON = "pokemonObject"

        fun startAcivity(activity: Activity, pokemon: Pokemon){
            val intent = Intent(activity, PokemonDetailActivity::class.java)
            intent.putExtra(KEY_POKEMON, pokemon)
            activity.startActivity(intent)
        }
    }

    fun getPokemon() : Pokemon =  intent.getSerializableExtra(KEY_POKEMON) as Pokemon

    @Inject
    lateinit var presenterProvider: Provider<PokemonDetailPresenter>

    @InjectPresenter
    lateinit var pokemonDetailPresenter: PokemonDetailPresenter

    @ProvidePresenter
    fun providePresenter(): PokemonDetailPresenter = presenterProvider.get()

    override val layoutId: Int = R.layout.activity_pokemon_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showInfo(pokemon: Pokemon) {

        Picasso.get().load(pokemon.sprites.frontDefault).into(imageViewFront)
        Picasso.get().load(pokemon.sprites.backDefault).into(imageViewBack)
        Picasso.get().load(pokemon.sprites.frontFemale).into(imageViewFemale)
        Picasso.get().load(pokemon.sprites.frontShiny).into(imageViewShiny)

        textViewNameValue.text = pokemon.name
        textViewHeightValue.text = "${pokemon.height}"
        textViewWeightValue.text = "${pokemon.weight}"


        pokemon.types.forEach{
            textViewTypeValue.append("${it.type.name} ")
        }

        pokemon.stats.forEach{
            when(it.stat.name){
                "attack" -> textViewAttackValue.text = "${it.baseStat}"
                "defense" -> textViewDefenseValue.text = "${it.baseStat}"
                "hp" -> textViewHpValue.text = "${it.baseStat}"
            }
        }

    }

}
