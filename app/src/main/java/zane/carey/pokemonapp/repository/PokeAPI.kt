package zane.carey.pokemonapp.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeAPI {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val pokemonService: PokeInterfaceService = retrofit.create(PokeInterfaceService::class.java)
    val itemService: ItemInterfaceService = retrofit.create(ItemInterfaceService::class.java)
    val moveService: MoveInterfaceService = retrofit.create(MoveInterfaceService::class.java)
    val regionService: RegionInterfaceService = retrofit.create(RegionInterfaceService::class.java)
}