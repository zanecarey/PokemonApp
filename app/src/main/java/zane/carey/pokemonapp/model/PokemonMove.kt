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
    var sprites: List<String?>?
)
