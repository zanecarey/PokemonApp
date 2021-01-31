package zane.carey.pokemonapp.database

import PokeItem
import androidx.lifecycle.LiveData
import androidx.room.*
import zane.carey.pokemonapp.model.Pokemon

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

    //ITEM COMMANDS
    @Query("SELECT * FROM PokeItem WHERE id = :id")
    fun getItemById(id: String?) : LiveData<PokeItem>

    @Query("SELECT * FROM PokeItem")
    fun getAllItems(): LiveData<List<PokeItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(pokeItem: PokeItem)

    @Query("DELETE FROM PokeItem")
    fun deleteAllItems()
}