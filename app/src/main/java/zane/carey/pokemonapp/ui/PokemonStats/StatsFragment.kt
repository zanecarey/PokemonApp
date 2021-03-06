package zane.carey.pokemonapp.ui.PokemonStats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_poke_stats.*
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerViewModel


class StatsFragment: Fragment() {


    companion object {
        @JvmStatic
        fun newInstance(id: String?) = StatsFragment().apply {
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
        return inflater.inflate(R.layout.fragment_poke_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeID = arguments?.getString("id")
        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->

                healthTextView.text = pokemon.health.toString()
                attackTextView.text = pokemon.attack.toString()
                defenseTextView.text = pokemon.defense.toString()
                spAttackTextView.text = pokemon.spAttack.toString()
                spDefenceTextView.text = pokemon.spDefense.toString()
                speedTextView.text = pokemon.speed.toString()

            }
        })
    }
}