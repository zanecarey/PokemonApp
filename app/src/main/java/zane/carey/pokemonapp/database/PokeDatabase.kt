package zane.carey.pokemonapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import zane.carey.pokemonapp.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class PokeDatabase: RoomDatabase() {

    abstract fun pokeDao(): PokeDAO

    companion object{
        @Volatile
        private var INSTANCE: PokeDatabase? = null
    }
}