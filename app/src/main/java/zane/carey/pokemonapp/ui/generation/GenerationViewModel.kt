package zane.carey.pokemonapp.ui.generation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokeGeneration
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.repository.Generation
import zane.carey.pokemonapp.repository.Item
import zane.carey.pokemonapp.repository.PokeAPI

class GenerationViewModel : ViewModel() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    fun getGenList(): LiveData<List<PokeGeneration>> {
        return pokeDao.getAllGens()
    }

    fun convertGen(gen: Generation): PokeGeneration {
        return PokeGeneration(
            gen.id,
            gen.name,
            listOf(gen.abilities[0].name),
            listOf(gen.names[0].name),
            gen.mainRegion.name,
            listOf(gen.moves[0].name),
            listOf(gen.pokemonSpecies[0].name),
            listOf(gen.types[0].name),
            listOf(gen.versionGroups[0].name)
        )
    }

    suspend fun getGen(id: Int) = PokeAPI.genService.getGen(id)
}