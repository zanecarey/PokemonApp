package zane.carey.pokemonapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.model.PokemonMove
import zane.carey.pokemonapp.model.Region

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

    //MOVE COMMANDS
    @Query("SELECT * FROM PokemonMove WHERE id = :id")
    fun getMoveById(id: String?) : LiveData<PokemonMove>

    @Query("SELECT * FROM PokemonMove")
    fun getAllMoves(): LiveData<List<PokemonMove>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMove(pokeMove: PokemonMove)

    @Query("DELETE FROM PokemonMove")
    fun deleteAllMoves()

    //REGION COMMANDS
    @Query("SELECT * FROM Region WHERE id = :id")
    fun getRegionById(id: String?) : LiveData<Region>

    @Query("SELECT * FROM Region")
    fun getAllRegions(): LiveData<List<Region>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRegion(region: Region)

    @Query("DELETE FROM Region")
    fun deleteAllRegions()

}