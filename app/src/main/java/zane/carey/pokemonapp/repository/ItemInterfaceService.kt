package zane.carey.pokemonapp.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface ItemInterfaceService {

    @GET("item/{id}/")
    suspend fun getItem(@Path("id") id: Int): Item
}