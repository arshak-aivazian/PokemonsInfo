package com.example.pokemonsinfo.di

import com.example.pokemonsinfo.PokemonApplication
import com.example.pokemonsinfo.repository.PokemonsRepository
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AndroidSupportInjectionModule::class,
    RepositoryModule::class,
    AcitivityBuilder::class])
@Singleton
interface AppComponent  : AndroidInjector<PokemonApplication>{

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<PokemonApplication>(){
        @BindsInstance
        abstract fun application(application: PokemonApplication) : Builder
    }

}
