package zane.carey.pokemonapp.ui.ViewPager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_viewpager.*
import zane.carey.pokemonapp.R

class ViewPagerFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_viewpager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeID = arguments?.getString("id")
        vpViewModel.getById(pokeID).observe(viewLifecycleOwner, Observer { pokemonValue ->
            pokemonValue?.let { pokemon ->

                pokemonNameTextView.text = pokemon.name?.capitalize()
                IDTextView.text = "#" + pokemon.id

                pokemon.type.let{ firstType ->
                    textViewType1.text = firstType.toString().substring(1, firstType.toString().length - 1).capitalize()

                }

                Glide.with(view.context)
                    .load(pokemon.sprites?.get(1))
                    .placeholder(android.R.drawable.btn_star)
                    .into(pokemonImageView)

                val viewPager = viewPager
                val pagerTabs = pagerTabs
                viewPager.adapter =
                    ViewPagerAdapter(requireFragmentManager(), requireContext(), pokemon.id)
                pagerTabs.setupWithViewPager(viewPager)
            }
        })
    }
}