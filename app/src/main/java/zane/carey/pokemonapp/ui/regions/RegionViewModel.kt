package zane.carey.pokemonapp.ui.regions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.Region
import zane.carey.pokemonapp.repository.Item
import zane.carey.pokemonapp.repository.PokeAPI

class RegionViewModel : ViewModel() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    fun getRegionList(): LiveData<List<Region>> {
        return pokeDao.getAllRegions()
    }

    fun convertRegion(region: Region): Region {
        return Region(

        )
    }

    fun testGetItem() {
        viewModelScope.launch(Dispatchers.IO) {
            var returnedRegion = getRegion(0)
            pokeDao.insertRegion(convertRegion(returnedRegion))
        }
    }

    suspend fun getRegion(id: Int) = PokeAPI.regionService.getRegion(id)

}