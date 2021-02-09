package zane.carey.pokemonapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.model.PokemonMove
import zane.carey.pokemonapp.model.Region

@Database(entities = [Pokemon::class, PokeItem::class, PokemonMove::class, Region::class], version = 9, exportSchema = false)
abstract class PokeDatabase: RoomDatabase() {

    abstract fun pokeDao(): PokeDAO

}