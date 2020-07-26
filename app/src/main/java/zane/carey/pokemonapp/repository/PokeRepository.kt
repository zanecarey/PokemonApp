package zane.carey.pokemonapp.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.Pokemon

class PokeRepository(private val pokeDao: PokeDAO) {

    val allPokemon: LiveData<List<Pokemon>> = pokeDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(pokemon: Pokemon){
        pokeDao.insert(pokemon)
    }
}