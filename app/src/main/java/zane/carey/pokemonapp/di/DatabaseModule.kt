package zane.carey.pokemonapp.di

import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import zane.carey.pokemonapp.R

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            androidApplication().baseContext.getString(R.string.app_name)
        ).build()
    }

    single {
        get<AppDatabase>().pokemonDAO()
    }
}