package zane.carey.pokemonapp.repository

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PokeInterfaceService {


    @GET("pokemon-color/")
    fun getPokemonColorList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Deferred<NamedApiResourceList>


}