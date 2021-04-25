package zane.carey.pokemonapp.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface GenInterfaceSerivce {

    @GET("gen/{id}/")
    suspend fun getGen(@Path("id") id: Int): Generation
}