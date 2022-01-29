package zane.carey.pokemonapp.ui.PokemonBio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_poke_bio.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import org.koin.android.viewmodel.ext.android.viewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonStats.StatsFragment
import zane.carey.pokemonapp.ui.PokemonViewModel
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerViewModel
import zane.carey.pokemonapp.util.ColorConverter


class BioFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(id: String?) = BioFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }

    //private lateinit var vpViewModel: ViewPagerViewModel
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
        return inflater.inflate(R.layout.fragment_poke_bio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeID = arguments?.getString("id")
        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->

                bioTextView.text = pokemon.flavorText?.replace("\\n".toRegex(), "")
                //typeTextView.text = pokemon.type.toString().substring(1, pokemon.type.toString().length - 1).capitalize()
                typeTextView.text = pokemon.type!![0].type.name.capitalize()
                weightTextView.text = pokemon.weight.toString()
                heightTextView.text = pokemon.height.toString()
                baseXPTextView.text = pokemon.baseXP.toString()
                genderRateTextView.text = pokemon.genderRate.toString()
                //bioCardView.setCardBackgroundColor(ColorConverter(view.context).getColor(pokemon.type?.get(0)?.type?.name))
            }
        })
    }
}