package zane.carey.pokemonapp.ui.PokemonAbilities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_poke_abilities.*
import kotlinx.android.synthetic.main.fragment_poke_stats.*
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

        val pokeID = arguments?.getString("id")
        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->

                //chop up the ability list into chunks
                val abilList = pokemon.abilities.toString().split(",").toTypedArray()
                ability1TextView.text = abilList[0]
                ability2TextView.text = abilList[1]
                ability3TextView.text = abilList[2]
//                ability1TextView.text = pokemon.abilities.toString().substring(1, pokemon.abilities.toString().length - 1).capitalize()
                movesTextView.text = pokemon.moves.toString().substring(1, pokemon.moves.toString().length - 1).capitalize()

            }
        })
    }
}