package com.example.pokemonsinfo.di

import com.example.pokemonsinfo.repository.ApiService
import com.example.pokemonsinfo.repository.PokemonsRepository
import com.example.pokemonsinfo.repository.impl.PokemonsRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideApiService() : ApiService = ApiService.create()

    @Provides
    @Singleton
    fun providePokemonsRepository(apiService: ApiService) : PokemonsRepository = PokemonsRepositoryImpl(apiService)


}