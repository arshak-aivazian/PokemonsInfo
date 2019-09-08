package com.example.pokemonsinfo.ui.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.pojo.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonsAdapter: RecyclerView.Adapter<PokemonsAdapter.PokemonViewHolder>() {

    private var pokemonList: List<Pokemon> = ArrayList()
    private var listener: OnSelectedItem? = null


    interface OnSelectedItem{
        fun onClick(pokemon: Pokemon)
    }

    fun setListener(listener: OnSelectedItem){
        this.listener = listener
    }

    fun setupPokemons(list: List<Pokemon>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokemon = pokemonList[position])
    }

    inner class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        init {
            itemView.setOnClickListener({
                listener?.onClick(pokemonList[adapterPosition])
            })
        }

        fun bind(pokemon: Pokemon){
            Picasso.get().load(pokemon.sprites.frontDefault).into(itemView.civAvatar)
            itemView.textViewName.text = pokemon.name
        }

    }
}