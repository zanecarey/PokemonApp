package zane.carey.pokemonapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.database.PokeDatabase
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokeRepository

class PokemonViewModel(application: Application): AndroidViewModel(application) {

    private val repository: PokeRepository
    private val pokeDAO: PokeDAO = App.database.pokeDao()

    val allPokemon: LiveData<List<Pokemon>>

    init {
        //val pokeDAO = PokeDatabase.getDatabase(application).pokeDao()
        repository = PokeRepository(pokeDAO)
        allPokemon = repository.allPokemon
    }

    fun insert(pokemon: Pokemon) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(pokemon)
    }

    fun getPokemonList(): LiveData<List<Pokemon>> {
        return pokeDAO.getAll()
    }
}