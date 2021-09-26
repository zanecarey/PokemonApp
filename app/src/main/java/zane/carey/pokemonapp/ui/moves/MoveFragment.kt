package zane.carey.pokemonapp.ui.moves

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.fragment_item.itemRecyclerView
import kotlinx.android.synthetic.main.fragment_moves.*
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.PokemonMove
import zane.carey.pokemonapp.ui.items.ItemAdapter
import zane.carey.pokemonapp.ui.items.ItemViewModel

class MoveFragment: Fragment() {

    private lateinit var moveViewModel: MoveViewModel
    private val pokeDao: PokeDAO = App.database.pokeDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        moveViewModel = ViewModelProvider(this).get(MoveViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_moves, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moveRecyclerView = moveRecyclerView
        val layoutManager = GridLayoutManager(context, 2)
        moveRecyclerView.layoutManager = layoutManager

        moveViewModel.testGetMove()
        moveViewModel.getMoveList().observe(viewLifecycleOwner, Observer {
            val moves: List<PokemonMove> = it
            moveRecyclerView.adapter = MoveAdapter(moves, view.context)
        })
    }
}