package zane.carey.pokemonapp.ui.items

import PokeItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.repository.Item
import zane.carey.pokemonapp.repository.PokeAPI

class ItemViewModel : ViewModel() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    fun getItemList(): LiveData<List<PokeItem>> {
        return pokeDao.getAllItems()
    }

    fun convertItem(item: Item): PokeItem {
        return PokeItem(
            item.id,
            item.name,
            item.cost,
            item.fling_power,
            item.fling_effect?.name,
            listOf(item.attributes[0].name),
            item.category.name,
            item.effect_entries[0].effect,
            item.flavor_text_entries[0].text,
            listOf(item.names[0].name),
            listOf(item.sprites.toString()),
            listOf(item.held_by_pokemon[0].pokemon.name)
        )
    }

    fun testGetItem() {
        viewModelScope.launch(Dispatchers.IO) {
            var returnedItem = getItem(0)
            pokeDao.insertItem(convertItem(returnedItem))
        }
    }

    suspend fun getItem(id: Int) = PokeAPI.itemService.getItem(id)
}