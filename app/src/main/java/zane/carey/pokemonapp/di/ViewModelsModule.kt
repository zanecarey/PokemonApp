package zane.carey.pokemonapp.di

import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelsModule = module {
    viewModel { DashboardViewModel(get()) }
    viewModel { GenerationViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { PokedexViewModel(get(), get()) }
}