package zane.carey.pokemonapp.repository


import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import zane.carey.pokemonapp.model.EvolutionChain

interface PokeInterfaceService {

    @GET("pokemon/{id}/")
    fun getPokemon(@Path("id") id: Int): Call<PokemonResults>

    @GET("pokemon-color/{id}/")
    fun getPokemonColor(@Path("id") id: Int): Deferred<PokemonColor>

    @GET("evolution-chain/{id}")
    fun getEvolutionChain(@Path("id") id: Int): Deferred<EvolutionChain>

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: Int): Deferred<PokemonSpecies>
}