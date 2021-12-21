package zane.carey.pokemonapp.ui.PokemonAbilities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_poke_abilities.*
import org.koin.android.viewmodel.ext.android.viewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonStats.StatsFragment
import zane.carey.pokemonapp.ui.PokemonViewModel
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerViewModel


class AbilitiesFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(id: String?) = AbilitiesFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }

    private val vpViewModel: ViewPagerViewModel by viewModel()

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        vpViewModel = ViewModelProvider(this).get(ViewPagerViewModel::class.java)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_abilities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moveListRecyclerView = moveListRecyclerView
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.isAutoMeasureEnabled
        moveListRecyclerView.layoutManager = layoutManager

        val pokeID = arguments?.getString("id")
        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->

                //chop up the ability list into chunks
                val abilList = pokemon.abilities.toString().split(",").toTypedArray()
                ability1TextView.text = abilList[0].substring(1, abilList[0].length).replaceFirst(abilList[0].get(1), abilList[0].get(1).toUpperCase())
                ability2TextView.text = abilList[1].replaceFirst(abilList[1][1], abilList[1].get(1).toUpperCase())
                //ability3TextView.text = abilList[2].substring(0,abilList[2].length - 1).capitalize()
//                ability1TextView.text = pokemon.abilities.toString().substring(1, pokemon.abilities.toString().length - 1).capitalize()
                //movesTextView.text = pokemon.moves.toString().substring(1, pokemon.moves.toString().length - 1).capitalize()
                moveListRecyclerView.adapter = MoveListAdapter(pokemon.moves, view.context)
            }
        })
    }
}