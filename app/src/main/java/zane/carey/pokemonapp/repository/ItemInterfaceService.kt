package zane.carey.pokemonapp.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface ItemInterfaceService {

    @GET("pokemon/{id}/")
    suspend fun getPokemon(@Path("id") id: Int): Item
}