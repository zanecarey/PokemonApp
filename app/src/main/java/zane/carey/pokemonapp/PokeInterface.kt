package zane.carey.pokemonapp

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

class PokeInterface {

    interface PokeInterface {
        @Headers("Content-Type: application/json")
        @GET("/api/v2/pokemon/{name}/")
        fun getData(
            @Path("name") pokeName: String
        ): Deferred<Results>
    }
}

data class Results(
    @SerializedName("id")
    val id: String,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("abilities")
    val abilities: List<String>,
    @SerializedName("species")
    val species: Int

)