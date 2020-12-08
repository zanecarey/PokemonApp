package zane.carey.pokemonapp.ui.items

import Item
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO

class ItemViewModel : ViewModel() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    fun getItemList(): LiveData<List<Item>> {
        return pokeDao.getAllItems()
    }
}