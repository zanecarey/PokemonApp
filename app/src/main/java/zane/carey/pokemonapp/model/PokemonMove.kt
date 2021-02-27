package zane.carey.pokemonapp.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import zane.carey.pokemonapp.util.StringConverter

@Entity
@TypeConverters(StringConverter::class)
data class PokemonMove(
    @PrimaryKey
    @NonNull
    var id: String,
    var name: String?,
    val accuracy: Int?,
    val effectChance: Int?,
    val pp: Int?,
    val priority: Int,
    val power: Int?,
    val damageClass: String?,
    val effectEntries: List<String>,
    val effectChanges: List<String>,
    val generation: String,
    val names: List<Name>,
    val target: String?,
    val type: String?
)
