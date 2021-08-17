package zane.carey.pokemonapp.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import zane.carey.pokemonapp.ui.HomeScreen.HomeScreenViewModel
import zane.carey.pokemonapp.ui.PokemonViewModel
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerViewModel
import zane.carey.pokemonapp.ui.genfilter.GenFilterViewModel

val viewModelsModule = module {
    viewModel { ViewPagerViewModel(get()) }
    viewModel { GenFilterViewModel(get()) }
    viewModel { HomeScreenViewModel(get()) }
    viewModel { PokemonViewModel(get()) }
}