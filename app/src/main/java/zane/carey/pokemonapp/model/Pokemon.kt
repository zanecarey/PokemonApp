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
}