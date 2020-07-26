package zane.carey.pokemonapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import zane.carey.pokemonapp.model.Pokemon

@Dao
interface PokeDAO {
    @Query("SELECT * FROM pokemon_table WHERE ID = :id")
    fun getById(id: String?): LiveData<Pokemon>

    @Query("SELECT * FROM pokemon_table")
    fun getAll(): LiveData<List<Pokemon>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pokemon: Pokemon)
}