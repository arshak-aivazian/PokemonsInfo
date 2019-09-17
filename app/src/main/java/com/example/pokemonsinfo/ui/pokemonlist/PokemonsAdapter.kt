package com.example.pokemonsinfo.ui.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonsinfo.R
import com.example.pokemonsinfo.pojo.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonsAdapter: PagedListAdapter<Pokemon, PokemonsAdapter.PokemonViewHolder>(PokemonListDiffUtil()) {

    private var listener: OnSelectedItem? = null


    interface OnSelectedItem{
        fun onClick(pokemon: Pokemon)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent, false))
    }


    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    fun setListener(listener: PokemonsAdapter.OnSelectedItem) {
        this.listener = listener
    }

    class PokemonListDiffUtil : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return true
        }
    }

    inner class PokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(pokemon: Pokemon){
            Picasso.get().load(pokemon.sprites.frontDefault).into(itemView.civAvatar)
            itemView.textViewName.text = pokemon.name

            itemView.setOnClickListener({
                listener?.onClick(pokemon)
            })
        }

    }
}