package zane.carey.pokemonapp.repository

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
    @SerializedName("name")
    val name: String,
    @SerializedName("baseExperience")
    val baseExperience: Int,
    @SerializedName("order")
    val order: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("abilities")
    val abilities: List<PokemonAbility>,
    @SerializedName("moves")
    val moves: List<PokemonMove>,
    @SerializedName("stats")
    val stats: List<PokemonStat>,
    @SerializedName("species")
    val species: Species,
    @SerializedName("types")
    val types: List<PokemonType>,
    @SerializedName("sprites")
    val sprites: PokemonSprite
)

data class PokemonAbility(
    val isHidden: Boolean,
    val slot: Int,
    val ability: Ability
)

data class Ability(
    val name: String
)

data class PokemonMove(
    val move: Move
    //val versionGroupDetails: List<PokemonMoveVersion>
)

data class Move(
    val name: String
)

data class PokemonStat(
    val stat: Stat,
    val effort: Int,
    val baseStat: Int
)

data class Stat(
    val name: String
)

data class PokemonType(
    val type: Type
)

data class Type(
    val type: String
)

data class PokemonSprite(
    val backDefault: String?,
    val backShiny: String?,
    val frontDefault: String?,
    val frontShiny: String?,
    val backFemale: String?,
    val backShinyFemale: String?,
    val frontFemale: String?,
    val frontShinyFemale: String?,
    val other : Other?
)

data class Other(
    val officialArtwork: String
)

data class Species(
    val name: String
)