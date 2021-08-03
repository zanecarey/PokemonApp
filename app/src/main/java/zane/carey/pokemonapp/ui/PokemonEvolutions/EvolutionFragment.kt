package zane.carey.pokemonapp.ui.PokemonEvolutions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_poke_bio.*
import kotlinx.android.synthetic.main.fragment_poke_evolutions.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import kotlinx.android.synthetic.main.poke_list_item.view.*
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonStats.StatsFragment
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerAdapter
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerFragment
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

                //get images for the first evolution pokemon
                val evoName = pokemon.evolutionChain?.get(0).toString().capitalize()
                firstEvolutionTextView.text = evoName
                vpViewModel.getByName(evoName.toLowerCase()).observe(viewLifecycleOwner, Observer { evoValue ->
                    evoValue?.let { poke ->
                        Glide.with(this)
                            .load(poke.sprites?.get(0))
                            .placeholder(android.R.color.transparent)
                            .into(firstEvoImage)

                        firstEvoImage.setOnClickListener{

                            var idBundle = bundleOf("name" to evoName.toLowerCase())
                            it.findNavController()
                                .navigate(R.id.action_navigation_evolutionFragment_to_viewpager, idBundle)
                        }
                    }
                })
            }
        })

    }
}