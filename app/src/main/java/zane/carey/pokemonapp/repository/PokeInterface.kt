package zane.carey.pokemonapp.repository

import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import zane.carey.pokemonapp.model.ApiResource
import zane.carey.pokemonapp.model.NamedApiResource

data class PokemonResults(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("base_experience")
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
    val species: NamedApiResource,
    @SerializedName("types")
    val types: List<PokemonType>,
    @SerializedName("sprites")
    val sprites: PokemonSprite
)

data class PokemonAbility(
    @SerializedName("Boolean")
    val isHidden: Boolean,
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("ability")
    val ability: Ability
)

data class Ability(
    @SerializedName("name")
    val name: String
)

data class PokemonMove(
    @SerializedName("move")
    val move: Move
    //val versionGroupDetails: List<PokemonMoveVersion>
)

data class Move(
    @SerializedName("name")
    val name: String
)

data class PokemonStat(
    @SerializedName("stat")
    val stat: Stat,
    @SerializedName("effort")
    val effort: Int,
    @SerializedName("base_stat")
    val baseStat: Int
)

data class Stat(
    @SerializedName("name")
    val name: String
)

data class PokemonType(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: NamedApiResource
)


data class PokemonSprite(
    @SerializedName("back_default")
    val backDefault: String?,
    @SerializedName("back_shiny")
    val backShiny: String?,
    @SerializedName("front_default")
    val frontDefault: String?,
    @SerializedName("front_shiny")
    val frontShiny: String?,
    @SerializedName("back_female")
    val backFemale: String?,
    @SerializedName("back_shiny_female")
    val backShinyFemale: String?,
    @SerializedName("front_female")
    val frontFemale: String?,
    @SerializedName("front_shiny_female")
    val frontShinyFemale: String?,
    @SerializedName("other")
    val other : Other?
)

data class Other(
    @SerializedName("officialArtwork")
    val officialArtwork: String
)

data class PokemonColor(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("pokemon_species")
    val pokemonSpecies: List<String>
)

data class PokemonSpecies(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: Int,
    @SerializedName("gender_rate")
    val genderRate: Int,
    @SerializedName("capture_rate")
    val captureRate: Int,
    @SerializedName("base_happiness")
    val baseHappiness: Int,
    @SerializedName("is_baby")
    val isBaby: Boolean,
    @SerializedName("is_legendary")
    val isLegendary: Boolean,
    @SerializedName("hatch_counter")
    val hatchCounter: Int,
    @SerializedName("has_gender_differences")
    val hasGenderDifferences: Boolean,
    @SerializedName("forms_switchable")
    val formsSwitchable: Boolean,
    @SerializedName("growth_rate")
    val growthRate: NamedApiResource,
    @SerializedName("pokedex_numbers")
    val pokedexNumbers: List<PokemonSpeciesDexEntry>,
    @SerializedName("egg_groups")
    val eggGroups: List<NamedApiResource>,
    @SerializedName("color")
    val color: NamedApiResource,
    @SerializedName("shape")
    val shape: NamedApiResource,
    @SerializedName("evolves_from_species")
    val evolvesFromSpecies: NamedApiResource?,
    //val evolutionChain: ApiResource,
    @SerializedName("habitat")
    val habitat: NamedApiResource?,
    @SerializedName("generation")
    val generation: NamedApiResource,
    //val formDescriptions: List<Description>,
    //val genera: List<Genus>,
    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<PokemonSpeciesFlavorText>
)

data class PokemonSpeciesFlavorText(
    @SerializedName("flavor_text")
    val flavorText: String,
    @SerializedName("language")
    val language: NamedApiResource,
    @SerializedName("version")
    val version: NamedApiResource
)

data class PokemonSpeciesDexEntry(
    @SerializedName("entry_number")
    val entryNumber: Int,
    @SerializedName("pokedex")
    val pokedex: NamedApiResource
)