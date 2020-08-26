package zane.carey.pokemonapp.model

import androidx.annotation.NonNull
import androidx.room.*

import retrofit2.Converter


@Entity(tableName = "pokemon_table")
@TypeConverters(Converter::class)
class Pokemon {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "pokemon")
    var id: String? = null
    var name: String? = null
    var height: Int? = null
    var weight: Int? = null
    var baseXP: Int? = null
    var abilities: List<String>? = null
    var moves: List<String>? = null
    var attack: Int? = null
    var health: Int? = null
    var defense: Int? = null
    var spAttack: Int? = null
    var spDefense: Int? = null
    var speed: Int? = null
    var type: List<String>? = null
}