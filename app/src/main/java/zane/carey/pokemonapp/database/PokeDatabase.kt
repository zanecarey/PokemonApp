package zane.carey.pokemonapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import zane.carey.pokemonapp.model.Pokemon

@Database(entities = [Pokemon::class], version = 1)
abstract class PokeDatabase: RoomDatabase() {

    abstract fun pokeDao(): PokeDAO

//    companion object{
//        @Volatile
//        private var INSTANCE: PokeDatabase? = null
//
//        fun getDatabase(
//            context: Context
//        ): PokeDatabase {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    PokeDatabase::class.java,
//                    "pokemon_database"
//                )
//                    .fallbackToDestructiveMigration()
//                    .allowMainThreadQueries()
//                    .build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}