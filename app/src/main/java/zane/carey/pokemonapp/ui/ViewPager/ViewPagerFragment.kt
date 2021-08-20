package zane.carey.pokemonapp.ui.ViewPager

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_poke_evolutions.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.util.ColorConverter

class ViewPagerFragment : Fragment() {

    private val vpViewModel: ViewPagerViewModel by viewModel()


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        vpViewModel = ViewModelProvider(this).get(ViewPagerViewModel::class.java)
//
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var pokeID = "1"


        if(arguments?.getString("name") != null){
            vpViewModel.getByName(arguments?.getString("name")).observe(viewLifecycleOwner, Observer { evoValue ->
                evoValue?.let { poke ->
                    //pokeID = poke.id
                    vpViewModel.getByName(poke.name?.toLowerCase()).observe(viewLifecycleOwner, Observer { pokemonValue ->
                        pokemonValue?.let { pokemon ->

                            appBarLayout.setBackgroundColor(ColorConverter(view.context).getColor(pokemon.type?.get(0)?.type?.name))
                            pokemonNameTextView.text = pokemon.name?.capitalize()
                            IDTextView.text = "#" + pokemon.id

                            pokemon.type.let{ firstType ->
                                //textViewType1.text = firstType.toString().substring(1, firstType.toString().length - 1).capitalize()
                                textViewType1.text = firstType!![0].type.name

                            }

                            Glide.with(view.context)
                                .load(pokemon.sprites?.get(1))
                                .placeholder(android.R.drawable.btn_star)
                                .into(pokemonImageView)

                            val viewPager = viewPager
                            val pagerTabs = pagerTabs
                            viewPager.adapter =
                                ViewPagerAdapter(parentFragmentManager, requireContext(), pokemon.id)
                            pagerTabs.setupWithViewPager(viewPager)
                        }
                    })
                }
            })
        } else {
            pokeID = arguments?.getString("id").toString()
            vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
                pokemonValue?.let { pokemon ->

                    appBarLayout.setBackgroundColor(ColorConverter(view.context).getColor(pokemon.type?.get(0)?.type?.name))
                    pokemonNameTextView.text = pokemon.name?.capitalize()
                    IDTextView.text = "#" + pokemon.id

                    pokemon.type.let{ firstType ->
                        //textViewType1.text = firstType.toString().substring(1, firstType.toString().length - 1).capitalize()
                        textViewType1.text = firstType!![0].type.name

                    }

                    Glide.with(view.context)
                        .load(pokemon.sprites?.get(1))
                        .placeholder(android.R.drawable.btn_star)
                        .into(pokemonImageView)

                    val viewPager = viewPager
                    val pagerTabs = pagerTabs
                    viewPager.adapter =
                        ViewPagerAdapter(parentFragmentManager, requireContext(), pokemon.id)
                    pagerTabs.setupWithViewPager(viewPager)
                }
            })
        }
        //val pokeID = arguments?.getString("id")

//        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
//            pokemonValue?.let { pokemon ->
//
//                appBarLayout.setBackgroundColor(ColorConverter(view.context).getColor(pokemon.type?.get(0)?.type?.name))
//                pokemonNameTextView.text = pokemon.name?.capitalize()
//                IDTextView.text = "#" + pokemon.id
//
//                pokemon.type.let{ firstType ->
//                    //textViewType1.text = firstType.toString().substring(1, firstType.toString().length - 1).capitalize()
//                    textViewType1.text = firstType!![0].type.name
//
//                }
//
//                Glide.with(view.context)
//                    .load(pokemon.sprites?.get(1))
//                    .placeholder(android.R.drawable.btn_star)
//                    .into(pokemonImageView)
//
//                val viewPager = viewPager
//                val pagerTabs = pagerTabs
//                viewPager.adapter =
//                    ViewPagerAdapter(parentFragmentManager, requireContext(), pokemon.id)
//                pagerTabs.setupWithViewPager(viewPager)
//            }
//        })
    }
}