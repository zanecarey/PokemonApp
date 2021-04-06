package zane.carey.pokemonapp.ui.generation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_generation.*
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.fragment_item.itemRecyclerView
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokeGeneration
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.ui.items.ItemAdapter
import zane.carey.pokemonapp.ui.items.ItemViewModel

class GenerationFragment: Fragment() {

    private lateinit var genViewModel: ItemViewModel
    private val pokeDao: PokeDAO = App.database.pokeDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        genViewModel = ViewModelProvider(this).get(ItemViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_region, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val genRecyclerView = genRecyclerView
        val layoutManager = GridLayoutManager(context, 2)
        genRecyclerView.layoutManager = layoutManager

        genViewModel.getItemList().observe(viewLifecycleOwner, Observer {
            val gens: List<PokeGeneration> = it
            genRecyclerView.adapter = GenerationAdapter(gens, view.context)
        })
    }
}