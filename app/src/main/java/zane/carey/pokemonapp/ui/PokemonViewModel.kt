package zane.carey.pokemonapp.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokeAPI
import zane.carey.pokemonapp.repository.PokemonResults
import kotlin.concurrent.thread

class PokemonViewModel: ViewModel() {

    private val pokeDAO: PokeDAO = App.database.pokeDao()


    init {
        initNetworkRequest()
    }

    private fun initNetworkRequest() {

        val call = PokeAPI.pokemonService.getPokemon(1)
        call.enqueue(object : Callback<PokemonResults?> {

            override fun onResponse(
                call: Call<PokemonResults?>,
                response: Response<PokemonResults?>
            ) {
                response.body()?.let { pokemons: PokemonResults ->
                    thread {
                        pokeDAO.insert(pokemons)
                    }
                }
            }

            override fun onFailure(call: Call<PokemonResults?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }


    fun getPokemonList(): LiveData<List<Pokemon>> {
        return pokeDAO.getAll()
    }
}

