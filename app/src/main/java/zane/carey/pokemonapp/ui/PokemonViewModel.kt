package zane.carey.pokemonapp.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.fragment_pokemon.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import retrofit2.Response
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokeAPI
import zane.carey.pokemonapp.repository.PokemonResults
import zane.carey.pokemonapp.repository.PokemonSpecies
import kotlin.concurrent.thread

class PokemonViewModel : ViewModel() {

    private val pokeDAO: PokeDAO = App.database.pokeDao()


//    init {
//        firstPoke()
//    }

    private fun initNetworkRequest() {

//        val call = PokeAPI.pokemonService.getPokemon(1)
//        call.enqueue(object : Callback<PokemonResults?> {
//
//            override fun onResponse(
//                call: Call<PokemonResults?>,
//                response: Response<PokemonResults?>
//            ) {
//                response.body()?.let { pokemons: PokemonResults ->
//                    thread {
//                        pokeDAO.insert(convert(pokemons))
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<PokemonResults?>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })

//        val firstPoke = liveData(Dispatchers.IO) {
//            val returnedPoke = getPoke(1)
//            pokeDAO.insert(convert(returnedPoke.body()!!))
//            emit(returnedPoke)
//        }

    }

    fun testGet() {
        viewModelScope.launch(Dispatchers.IO) {
            var returnedPoke = getPoke(3)
//            returnedPoke = getPoke(4)
//            pokeDAO.insert(convert(returnedPoke))
//            returnedPoke = getPoke(5)
//            pokeDAO.insert(convert(returnedPoke))
            //Get the rest of the pokemon info
            var extraInfo = getExtraPokeInfo(3)
            pokeDAO.insert(convert(returnedPoke,extraInfo))
        }
    }

    fun getPokemonList(): LiveData<List<Pokemon>> {
        return pokeDAO.getAll()
    }

    fun convert(pokemonResults: PokemonResults, pokemonSpecies: PokemonSpecies): Pokemon {
        return Pokemon(
            pokemonResults.id,
            pokemonResults.name,
            pokemonResults.height,
            pokemonResults.weight,
            pokemonResults.baseExperience,
            //listOf(pokemonResults.abilities[0].ability.name),
            //listOf(pokemonResults.moves[0].move.name),
            pokemonResults.stats[0].baseStat,
            pokemonResults.stats[1].baseStat,
            pokemonResults.stats[2].baseStat,
            pokemonResults.stats[3].baseStat,
            pokemonResults.stats[4].baseStat,
            pokemonResults.stats[5].baseStat
            //pokemonResults.gender
            //pokemonResults.types[0].type.type
            //listOf(pokemonResults.sprites.backDefault)
        )


    }

    suspend fun getPoke(id : Int) = PokeAPI.pokemonService.getPokemon(id)
    suspend fun getExtraPokeInfo(id : Int) = PokeAPI.pokemonService.getPokemonSpecies(id)
}

