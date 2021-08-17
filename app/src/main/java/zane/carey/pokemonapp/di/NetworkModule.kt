package zane.carey.pokemonapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import zane.carey.pokemonapp.repository.PokeInterfaceService

val networkModule = module {
    single<Retrofit> {

        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    single {
        get<Retrofit>().create<PokeInterfaceService>()
    }
}