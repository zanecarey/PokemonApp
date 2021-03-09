package zane.carey.pokemonapp.ui.moves

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.PokemonMove
import zane.carey.pokemonapp.repository.Item
import zane.carey.pokemonapp.repository.Move
import zane.carey.pokemonapp.repository.PokeAPI

class MoveViewModel: ViewModel() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    fun getMoveList(): LiveData<List<PokemonMove>> {
        return pokeDao.getAllMoves()
    }

    fun convertMove(move: Move): PokemonMove {
        return PokemonMove(
            move.id,
            move.name,
            move.accuracy,
            move.effect_chance,
            move.pp,
            move.priority,
            move.power,
            move.damage_class.name,
            listOf(move.effect_entries[0].effect),
            listOf(move.effect_changes[0].toString()),
            move.generation.name.toString(),
            listOf(move.names[0].name),
            move.target.name,
            move.type.name
        )
    }

    fun testGetMove() {
        viewModelScope.launch(Dispatchers.IO) {
            var returnedMove = getMove(0)
            pokeDao.insertMove(convertMove(returnedMove))
        }
    }

    suspend fun getMove(id: Int) = PokeAPI.moveService.getMove(id)
}