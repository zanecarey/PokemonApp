package zane.carey.pokemonapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import zane.carey.pokemonapp.model.*

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
    @Query("SELECT * FROM PokemonRegion WHERE id = :id")
    fun getRegionById(id: String?) : LiveData<PokemonRegion>

    @Query("SELECT * FROM PokemonRegion")
    fun getAllRegions(): LiveData<List<PokemonRegion>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRegion(pokemonRegion: PokemonRegion)

    @Query("DELETE FROM PokemonRegion")
    fun deleteAllRegions()

    //GEN COMMANDS
    @Query("SELECT * FROM PokeGeneration WHERE id = :id")
    fun getGenById(id: String?) : LiveData<PokeGeneration>

    @Query("SELECT * FROM PokeGeneration")
    fun getAllGens(): LiveData<List<PokeGeneration>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGen(pokeGen: PokeGeneration)

    @Query("DELETE FROM PokeGeneration")
    fun deleteAllGenss()
}