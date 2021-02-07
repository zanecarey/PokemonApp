package zane.carey.pokemonapp.repository

import retrofit2.http.GET
import retrofit2.http.Path

interface MoveInterfaceService {

    @GET("move/{id}/")
    suspend fun getMove(@Path("id") id: Int): Move
}