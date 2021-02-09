package zane.carey.pokemonapp.repository

import retrofit2.http.GET
import retrofit2.http.Path
import zane.carey.pokemonapp.model.Region

interface RegionInterfaceService {

    @GET("region/{id}/")
    suspend fun getRegion(@Path("id") id: Int): Region
}