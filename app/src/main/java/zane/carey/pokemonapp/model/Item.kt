import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import zane.carey.pokemonapp.util.StringConverter

@Entity
@TypeConverters(StringConverter::class)
data class Item(
    @PrimaryKey
    @NonNull
    var id: String,
    var name: String? = null
)
