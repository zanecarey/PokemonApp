package zane.carey.pokemonapp.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import zane.carey.pokemonapp.util.StringConverter

@Entity
@TypeConverters(StringConverter::class)
data class PokeGeneration (
    @PrimaryKey
    @NonNull
    var id: String,
    var name: String? = null,
    val abilities: List<String?>?,
    val names: List<String?>?,
    val mainRegion: String?,
    val moves: List<String?>?,
    val pokemonSpecies: List<String?>?,
    val types: List<String?>?,
    val versionGroups: List<String?>?
)