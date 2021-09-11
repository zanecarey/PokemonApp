package zane.carey.pokemonapp.ui.PokemonStats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_poke_stats.*
import org.koin.android.viewmodel.ext.android.viewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonViewModel
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

                progressBarHP.progress = pokemon.health ?: 0
                progressBarAttack.progress = pokemon.attack ?: 0
                progressBarDef.progress = pokemon.defense ?: 0
                progressBarSpAtk.progress = pokemon.spAttack ?: 0
                progressBarSpDef.progress = pokemon.spDefense ?: 0
                progressBarSpeed.progress = pokemon.speed ?: 0
            }
        })
    }
}