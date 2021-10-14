package zane.carey.pokemonapp.ui.PokemonSearch

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_poke_search.*
import kotlinx.android.synthetic.main.fragment_poke_search.view.*
import kotlinx.android.synthetic.main.poke_list_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.EvolutionChain
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokeAPI
import zane.carey.pokemonapp.repository.PokemonResults
import zane.carey.pokemonapp.repository.PokemonSpecies
import zane.carey.pokemonapp.ui.PokemonAdapter
import zane.carey.pokemonapp.ui.PokemonFragment
import zane.carey.pokemonapp.ui.PokemonViewModel

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.searchEntry.setOnFocusChangeListener{
            v, b -> if(b){view.searchEntry.text.clear()}
        }
        view.searchButton.setOnClickListener {
            val entry = view.searchEntry.text.toString()
            //view.searchTest.text = entry
            //make api call with entered name
            val job = CoroutineScope(Dispatchers.Main).launch {
                val results = getPoke(entry)
                withContext(Dispatchers.Main) {
                    searchEntry.setText(results.id)


                    var idBundle = bundleOf("id" to results.id)
                    it.findNavController()
                        .navigate(
                            R.id.action_navigation_main_to_navigation_poke_viewpager,
                            idBundle
                        )
                }

            }
        }


    }

    suspend fun getPoke(id: String) = PokeAPI.pokemonService.getPokemon(id)


}