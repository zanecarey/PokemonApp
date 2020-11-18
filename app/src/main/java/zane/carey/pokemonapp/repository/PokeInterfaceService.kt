package zane.carey.pokemonapp.repository


import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import zane.carey.pokemonapp.model.EvolutionChain

interface PokeInterfaceService {

    @GET("pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: Int): PokemonResults

    @GET("pokemon-color/{id}/")
    fun getPokemonColor(@Path("id") id: Int): PokemonColor

    @GET("evolution-chain/{id}")
    fun getEvolutionChain(@Path("id") id: Int): EvolutionChain

    @GET("pokemon-species/{id}/")
    fun getPokemonSpecies(@Path("id") id: Int): PokemonSpecies
}