package zane.carey.pokemonapp.database

import PokeItem
import androidx.room.Database
import androidx.room.RoomDatabase
import zane.carey.pokemonapp.model.Pokemon

@Database(entities = [Pokemon::class, PokeItem::class], version = 9, exportSchema = false)
abstract class PokeDatabase: RoomDatabase() {

    abstract fun pokeDao(): PokeDAO

}