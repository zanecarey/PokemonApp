package zane.carey.pokemonapp.repository

import zane.carey.pokemonapp.model.*

data class Item(
    val id: Int,
    val name: String,
    val cost: Int,
    val fling_power: Int?,
    val fling_effect: NamedApiResource?,
    val attributes: List<NamedApiResource>,
    val category: NamedApiResource,
    val effect_entries: List<VerboseEffect>,
    val flavor_text_entries: List<VersionGroupFlavorText>,
    val game_indices: List<GenerationGameIndex>,
    val names: List<Name>,
    val held_by_pokemon: List<ItemHolderPokemon>,
    val baby_trigger_for: ApiResource?,
    val sprites: ItemSprites
)

data class ItemSprites(
    val default: String?
)

data class ItemHolderPokemon(
    val pokemon: NamedApiResource,
    val version_details: List<ItemHolderPokemonVersionDetail>
)

data class ItemHolderPokemonVersionDetail(
    val rarity: Int,
    val version: NamedApiResource
)

data class ItemAttribute(
    val id: Int,
    val name: String,
    val items: List<NamedApiResource>,
    val names: List<Name>,
    val descriptions: List<Description>
)

data class ItemCategory(
    val id: Int,
    val name: String,
    val items: List<NamedApiResource>,
    val names: List<Name>,
    val pocket: NamedApiResource
)

data class ItemFlingEffect(
    val id: Int,
    val name: String,
    val effect_entries: List<Effect>,
    val items: List<NamedApiResource>
)

data class ItemPocket(
    val id: Int,
    val name: String,
    val categories: List<NamedApiResource>,
    val names: List<Name>
)