package zane.carey.pokemonapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import zane.carey.pokemonapp.database.PokeDatabase

class App: Application() {

    companion object {
        lateinit var context: Context
        lateinit var database: PokeDatabase
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        database = Room.databaseBuilder(
            this,
            PokeDatabase::class.java,
            "pokemon_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}