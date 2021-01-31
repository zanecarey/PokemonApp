import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import zane.carey.pokemonapp.model.NamedApiResource
import zane.carey.pokemonapp.util.StringConverter

@Entity
@TypeConverters(StringConverter::class)
data class PokeItem(
    @PrimaryKey
    @NonNull
    var id: String,
    var name: String? = null,
    val cost: Int,
    val flingPower: Int?,
    val flingEffect: String?,
    val attributes: List<String?>?,
    val category: String?,
    val effectEntry: String?,
    val flavorTextEntry: String?,
    val names: List<String?>?,
    val sprites: List<String?>? = null,
    val heldByPokemon: List<String?>?

)
