package zane.carey.pokemonapp.ui.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.Entity
import androidx.room.TypeConverters
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.fragment_pokemon.*
import kotlinx.android.synthetic.main.fragment_pokemon.pokedexRecyclerView
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.ui.PokemonAdapter
import zane.carey.pokemonapp.ui.PokemonViewModel
import zane.carey.pokemonapp.util.StringConverter


class ItemFragment: Fragment() {

    private lateinit var itemViewModel: ItemViewModel
    private val pokeDao: PokeDAO = App.database.pokeDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemRecyclerView = itemRecyclerView
        val layoutManager = GridLayoutManager(context, 2)
        itemRecyclerView.layoutManager = layoutManager

        itemViewModel.getItemList().observe(viewLifecycleOwner, Observer {
            val items: List<PokeItem> = it
            itemRecyclerView.adapter = ItemAdapter(items, view.context)
        })
    }
}