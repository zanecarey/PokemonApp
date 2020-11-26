package zane.carey.pokemonapp.model

import com.google.gson.annotations.SerializedName


data class EvolutionChain(
    @SerializedName("id")
    val id: Int,
    @SerializedName("baby_trigger_item")
    val babyTriggerItem: NamedApiResource?,
    @SerializedName("chain")
    val chain: ChainLink
)

data class ChainLink(
    @SerializedName("is_baby")
    val isBaby: Boolean,
    @SerializedName("species")
    val species: NamedApiResource,
    @SerializedName("evolution_details")
    val evolutionDetails: List<EvolutionDetail>,
    @SerializedName("evolves_to")
    val evolvesTo: List<ChainLink>
)

data class EvolutionDetail(
    @SerializedName("trigger")
    val trigger: NamedApiResource,
    @SerializedName("item")
    val item: NamedApiResource? = null,
    @SerializedName("gender")
    val gender: Int? = null,
    @SerializedName("held_item")
    val heldItem: NamedApiResource? = null,
    @SerializedName("known_move")
    val knownMove: NamedApiResource? = null,
    @SerializedName("known_move_type")
    val knownMoveType: NamedApiResource? = null,
    @SerializedName("location")
    val location: NamedApiResource? = null,
    @SerializedName("min_level")
    val minLevel: Int? = null,
    @SerializedName("min_happiness")
    val minHappiness: Int? = null
//    @SerializedName("known_move")
//    val minBeauty: Int? = null
//    val minAffection: Int? = null,
//    val partySpecies: NamedApiResource? = null,
//    val partyType: NamedApiResource? = null,
//    val relativePhysicalStats: Int? = null,
//    val timeOfDay: String = "",
//    val tradeSpecies: NamedApiResource? = null,
//    val needsOverworldRain: Boolean = false,
//    val turnUpsideDown: Boolean = false
)


