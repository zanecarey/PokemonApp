package zane.carey.pokemonapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import zane.carey.pokemonapp.model.*

@Database(entities = [Pokemon::class, PokeItem::class, PokemonMove::class, PokemonRegion::class, PokeGeneration::class], version = 13, exportSchema = false)
abstract class PokeDatabase: RoomDatabase() {

    abstract fun pokeDao(): PokeDAO

}