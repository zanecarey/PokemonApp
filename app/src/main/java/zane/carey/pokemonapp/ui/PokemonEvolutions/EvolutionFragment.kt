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
import org.koin.android.viewmodel.ext.android.viewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonStats.StatsFragment
import zane.carey.pokemonapp.ui.PokemonViewModel
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
        return inflater.inflate(R.layout.fragment_poke_evolutions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeID = arguments?.getString("id")
        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->

                //get images for the first evolution pokemon
                val baseEvoName = pokemon.evolutionChain?.get(0)
                val firstEvoName = pokemon.evolutionChain?.get(1)
                val secondEvoName = pokemon.evolutionChain?.get(2)

                //baseEvolutionTextView.text = baseEvoName
                vpViewModel.getByName(baseEvoName?.toLowerCase()).observe(viewLifecycleOwner, Observer { evoValue ->
                    evoValue?.let { poke ->
                        Glide.with(this)
                            .load(poke.sprites?.get(1))
                            .placeholder(android.R.color.transparent)
                            .into(baseEvoImage)

                        baseEvoImage.setOnClickListener{

                            var idBundle = bundleOf("name" to baseEvoName?.toLowerCase())
                            it.findNavController()
                                .navigate(R.id.action_navigation_evolutionFragment_to_viewpager, idBundle)
                        }
                    }
                })

                //firstEvolutionTextView.text = firstEvoName
                vpViewModel.getByName(firstEvoName?.toLowerCase()).observe(viewLifecycleOwner, Observer { evoValue ->
                    evoValue?.let { poke ->
                        Glide.with(this)
                            .load(poke.sprites?.get(1))
                            .placeholder(android.R.color.transparent)
                            .into(firstEvoImage)

                        firstEvoImage.setOnClickListener{

                            var idBundle = bundleOf("name" to firstEvoName?.toLowerCase())
                            it.findNavController()
                                .navigate(R.id.action_navigation_evolutionFragment_to_viewpager, idBundle)
                        }
                    }
                })

                //secondEvolutionTextView.text = secondEvoName
                vpViewModel.getByName(secondEvoName?.toLowerCase()).observe(viewLifecycleOwner, Observer { evoValue ->
                    evoValue?.let { poke ->
                        Glide.with(this)
                            .load(poke.sprites?.get(1))
                            .placeholder(android.R.color.transparent)
                            .into(secondEvoImage)

                        secondEvoImage.setOnClickListener{

                            var idBundle = bundleOf("name" to secondEvoName?.toLowerCase())
                            it.findNavController()
                                .navigate(R.id.action_navigation_evolutionFragment_to_viewpager, idBundle)
                        }
                    }
                })
            }
        })

    }
}