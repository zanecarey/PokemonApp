package zane.carey.pokemonapp.model

import androidx.annotation.NonNull
import androidx.room.*

import retrofit2.Converter
import zane.carey.pokemonapp.util.StringConverter


@Entity(tableName = "pokemon_table")
@TypeConverters(StringConverter::class)
data class Pokemon(
    @ColumnInfo(name = "pokemon")
    @PrimaryKey
    @NonNull
    var id: String,
    var name: String? = null,
    var height: Int? = null,
    var weight: Int? = null,
    var baseXP: Int? = null,
    var abilities: List<String>? = null,
    var moves: List<String>? = null,
    var attack: Int? = null,
    var health: Int? = null,
    var defense: Int? = null,
    var spAttack: Int? = null,
    var spDefense: Int? = null,
    var speed: Int? = null,
    var gender: String? = null,
    var type: List<String>? = null,
    var flavorText: String? = null,
    var evolutionChain: List<String>? = null,
    var sprites: List<String>? = null
)
