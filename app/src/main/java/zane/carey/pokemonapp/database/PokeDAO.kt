package zane.carey.pokemonapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokemonResults

@Dao
interface PokeDAO {
    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: String?): LiveData<Pokemon>

    @Query("SELECT * FROM pokemon")
    fun getAll(): LiveData<List<Pokemon>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pokemon: Pokemon)

    @Query("DELETE FROM pokemon")
    fun deleteAll()

    @Delete
    fun delete(model: Pokemon)
}