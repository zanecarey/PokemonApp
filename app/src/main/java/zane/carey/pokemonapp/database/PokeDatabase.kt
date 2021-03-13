package zane.carey.pokemonapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.model.PokemonMove
import zane.carey.pokemonapp.model.PokemonRegion

@Database(entities = [Pokemon::class, PokeItem::class, PokemonMove::class, PokemonRegion::class], version = 10, exportSchema = false)
abstract class PokeDatabase: RoomDatabase() {

    abstract fun pokeDao(): PokeDAO

}