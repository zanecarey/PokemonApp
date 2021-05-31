package zane.carey.pokemonapp.ui.PokemonSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.fragment_poke_search.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.repository.PokeAPI

class SearchFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.searchButton.setOnClickListener {
            val entry = view.searchEntry.text.toString()
            //view.searchTest.text = entry
            //make api call with entered name
            val job = CoroutineScope(Dispatchers.Main).launch{

                withContext(Dispatchers.Main) {

                    val results = getPoke(entry)
                }
            } //update ui info


        }
    }

    suspend fun getPoke(id : String) = PokeAPI.pokemonService.getPokemon(id)
}