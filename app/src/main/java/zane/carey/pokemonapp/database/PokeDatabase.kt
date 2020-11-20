package zane.carey.pokemonapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.util.StringConverter

@Database(entities = [Pokemon::class], version = 7, exportSchema = false)
abstract class PokeDatabase: RoomDatabase() {

    abstract fun pokeDao(): PokeDAO

}