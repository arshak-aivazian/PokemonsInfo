package com.example.pokemonsinfo.repository

import com.example.pokemonsinfo.pojo.Pokemon
import com.example.pokemonsinfo.pojo.PokemonListResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon?")
    fun getPokemonList(
        @Query("offset") offset: Int, @Query("limit") limit: Int
    ): Observable<PokemonListResponse>

    @GET("pokemon/{name}")
    fun getPokemonInfo(
        @Path("name") name: String
    ): Observable<Pokemon>

    companion object Factory {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pokeapi.co/api/v2/")
                .build()

            return retrofit.create(ApiService::class.java);
        }
    }

}