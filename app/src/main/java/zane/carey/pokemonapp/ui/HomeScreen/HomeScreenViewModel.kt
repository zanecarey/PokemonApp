package zane.carey.pokemonapp.ui.HomeScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Category
import zane.carey.pokemonapp.ui.PokemonViewModel

class HomeScreenViewModel : ViewModel() {

    private val listMenu = MutableLiveData<List<Category>>()

    fun getListMenu(): LiveData<List<Category>> {
        listMenu.value = listOf(
            Category(1, "Pokemon", R.color.red),
            Category(2, "Generation", R.color.green),
            Category(3, "Types", R.color.blue),
            Category(4, "Locations", R.color.orange),
            Category(5, "Pokemon", R.color.purple),
            Category(6, "Items", R.color.yellow)
        )
        return listMenu
    }
}