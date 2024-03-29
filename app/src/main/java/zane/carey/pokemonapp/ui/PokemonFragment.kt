package zane.carey.pokemonapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_pokemon.*
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.ext.android.viewModel
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.repository.PokeAPI
import zane.carey.pokemonapp.repository.PokemonResults
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerViewModel
import zane.carey.pokemonapp.ui.genfilter.GenFilterFragment

class PokemonFragment : Fragment() {

    private val pokeViewModel: PokemonViewModel by viewModel()
    private val pokeDAO: PokeDAO = App.database.pokeDao()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pokemon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemonRecyclerView = pokedexRecyclerView
        val layoutManager = GridLayoutManager(context, 1)
        pokemonRecyclerView.layoutManager = layoutManager

        floatingActionButton.setOnClickListener {
            //bring up type selection

            showTypeSelect()

        }
        pokeViewModel.testGet()
        pokeViewModel.getPokemonList().observe(viewLifecycleOwner, Observer {
            val pokemons: List<Pokemon> = it
            pokedexRecyclerView.adapter = PokemonAdapter(pokemons, view.context)
        })
    }

    private fun showTypeSelect() {
        val dialog = GenFilterFragment()
        dialog.show(parentFragmentManager, "")
    }
}