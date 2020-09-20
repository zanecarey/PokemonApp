package zane.carey.pokemonapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokemonResults

@Dao
interface PokeDAO {
    @Query("SELECT * FROM pokemon_table WHERE ID = :id")
    fun getById(id: String?): LiveData<Pokemon>

    @Query("SELECT * FROM pokemon_table")
    fun getAll(): LiveData<List<Pokemon>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pokemon: PokemonResults)

    @Query("DELETE FROM pokemon_table")
    fun deleteAll()

    @Delete
    fun delete(model: Pokemon)
}