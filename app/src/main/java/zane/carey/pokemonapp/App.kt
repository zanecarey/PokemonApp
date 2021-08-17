package zane.carey.pokemonapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import zane.carey.pokemonapp.database.PokeDatabase

class App: Application() {

    companion object {
        lateinit var context: Context
        lateinit var database: PokeDatabase
    }

    override fun onCreate() {
        super.onCreate()
        context = this

//        startKoin {
//            androidLogger()
//            androidContext(this@App)
//            modules(listOf(module1, module2))
//        }

        database = Room.databaseBuilder(
            this,
            PokeDatabase::class.java,
            "pokemon_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}