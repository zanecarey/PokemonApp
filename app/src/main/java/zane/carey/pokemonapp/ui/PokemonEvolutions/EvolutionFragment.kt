package zane.carey.pokemonapp.ui.PokemonEvolutions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_poke_bio.*
import kotlinx.android.synthetic.main.fragment_poke_evolutions.*
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonStats.StatsFragment
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerViewModel

class EvolutionFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(id: String?) = EvolutionFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }

    private lateinit var vpViewModel: ViewPagerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vpViewModel = ViewModelProvider(this).get(ViewPagerViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_poke_evolutions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeID = arguments?.getString("id")
        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->

                firstEvolutionTextView.text = pokemon.evolutionChain?.get(0).toString().capitalize()
                //typeTextView.text = pokemon.type.toString()
//                weightTextView.text = pokemon.weight.toString()
//                heightTextView.text = pokemon.height.toString()
//                baseXPTextView.text = pokemon.baseXP.toString()
            }
        })
    }
}