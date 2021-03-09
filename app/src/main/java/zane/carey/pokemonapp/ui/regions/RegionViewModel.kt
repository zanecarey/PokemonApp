package zane.carey.pokemonapp.ui.regions

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokemonRegion
import zane.carey.pokemonapp.repository.PokeAPI
import zane.carey.pokemonapp.repository.Region

class RegionViewModel : ViewModel() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    fun getRegionList(): LiveData<List<PokemonRegion>> {
        return pokeDao.getAllRegions()
    }

    fun convertRegion(region: Region): PokemonRegion {
        return PokemonRegion(
            region.id,
            region.name,
            listOf(region.locations[0].name),
            region.main_generation.name
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