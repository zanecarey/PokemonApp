package zane.carey.pokemonapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import zane.carey.pokemonapp.database.PokeDatabase
import zane.carey.pokemonapp.di.appComponent

class App: Application() {

    companion object {
        lateinit var context: Context
        lateinit var database: PokeDatabase
    }

    override fun onCreate() {
        super.onCreate()
        context = this

        startKoin {
            androidContext(this@App)
            modules(appComponent)
        }

        database = Room.databaseBuilder(
            this,
            PokeDatabase::class.java,
            "pokemon_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}