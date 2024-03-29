package zane.carey.pokemonapp.ui


import android.content.Context
import android.text.TextUtils.substring
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
import zane.carey.pokemonapp.model.EvolutionChain
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokeAPI
import zane.carey.pokemonapp.repository.PokemonResults
import zane.carey.pokemonapp.repository.PokemonSpecies
import kotlin.concurrent.thread

class PokemonViewModel(private val context: Context) : ViewModel() {

    private val pokeDAO: PokeDAO = App.database.pokeDao()


//    init {
//        firstPoke()
//    }

    private fun initNetworkRequest() {

    }

    fun testGet() {
        viewModelScope.launch(Dispatchers.IO) {
//            returnedPoke = getPoke(4)
//            returnedPoke = getPoke(5)
//            pokeDAO.insert(convert(returnedPoke))
            //Get the rest of the pokemon info
            for(i in 1..9){
                val returnedPoke = getPoke(i)
                val extraInfo = getExtraPokeInfo(i)
                //val chainLink = extraInfo.evolutionChain.name.substring(41,  extraInfo.evolutionChain.name.length -1).toInt()
                val chainLink = extraInfo.evolutionChain.url.substring(42,  extraInfo.evolutionChain.url.length -1).toInt()
                val evoChain = getEvoChain(chainLink.toInt())
                pokeDAO.insert(convert(returnedPoke,extraInfo,evoChain))
            }
//            var returnedPoke = getPoke(1)
//            var extraInfo = getExtraPokeInfo(1)
//            var evoChain = getEvoChain(1)
//            pokeDAO.insert(convert(returnedPoke,extraInfo,evoChain))
        }
    }

    fun getPokemonList(): LiveData<List<Pokemon>> {
        return pokeDAO.getAll()
    }

    fun convert(pokemonResults: PokemonResults, pokemonSpecies: PokemonSpecies, evolutionChain: EvolutionChain): Pokemon {


        var chainList = mutableListOf(evolutionChain.chain.species.name)

        //make list of evolution
        if(!evolutionChain.chain.evolvesTo.isEmpty()){
            chainList.add(evolutionChain.chain.evolvesTo[0].species.name)
            if(!evolutionChain.chain.evolvesTo[0].evolvesTo.isEmpty()){
                chainList.add(evolutionChain.chain.evolvesTo[0].evolvesTo[0].species.name)
            }
        }

        //make list of abilities
        var abilityList = mutableListOf(pokemonResults.abilities[0].ability.name)
        if(pokemonResults.abilities.size > 1){
            for(i in 1 until pokemonResults.abilities.size){
                abilityList.add(pokemonResults.abilities[i].ability.name)
            }
        }

//        for(a in pokemonResults.abilities.indices){
//            abilityList.add(pokemonResults.abilities[a].ability.name)
//        }

        //make list of moves
        var moveList = mutableListOf(pokemonResults.moves[0].move.name)
        for(m in pokemonResults.moves.indices){
            moveList.add(pokemonResults.moves[m].move.name)
        }

        return Pokemon(
            pokemonResults.id,
            pokemonResults.name,
            pokemonResults.height,
            pokemonResults.weight,
            pokemonResults.baseExperience,
            pokemonResults.stats[0].baseStat,//hp
            pokemonResults.stats[1].baseStat,//attack
            pokemonResults.stats[2].baseStat,//defense//
            pokemonResults.stats[3].baseStat,//spAttack
            pokemonResults.stats[4].baseStat,//spDefense
            pokemonResults.stats[5].baseStat,//speed
            pokemonSpecies.flavorTextEntries[1].flavorText,
            pokemonResults.types,
            chainList,
            //listOf(evolutionChain.chain.species.name, evolutionChain.chain.evolvesTo[0].species.name, evolutionChain.chain.evolvesTo[0].evolvesTo[0].species.name),
            //listOf(evolutionChain.chain.species.name, evolutionChain.chain.evolvesTo[0].species.name),
            listOf(pokemonResults.sprites.backDefault,pokemonResults.sprites.frontDefault),
            //listOf(pokemonResults.abilities[0].ability.name),
            abilityList,
            //listOf(pokemonResults.moves[0].move.name, pokemonResults.moves[1].move.name),
            moveList,
            pokemonSpecies.genderRate,
            pokemonSpecies.captureRate,
            pokemonSpecies.baseHappiness,
            pokemonSpecies.isLegendary,
            pokemonSpecies.growthRate.name,
            pokemonSpecies.color.name,
            pokemonSpecies.shape.name,
            pokemonSpecies.habitat?.name,
            pokemonSpecies.generation.name
        )
    }


    suspend fun getPoke(id : Int) = PokeAPI.pokemonService.getPokemon(id)
    suspend fun getExtraPokeInfo(id : Int) = PokeAPI.pokemonService.getPokemonSpecies(id)
    suspend fun getEvoChain(id : Int) = PokeAPI.pokemonService.getEvolutionChain(id)


}

