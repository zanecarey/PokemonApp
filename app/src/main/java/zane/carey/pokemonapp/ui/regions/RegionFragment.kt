package zane.carey.pokemonapp.ui.regions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_region.*
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokemonRegion

class RegionFragment: Fragment(){
    private lateinit var regionViewModel: RegionViewModel
    private val pokeDao: PokeDAO = App.database.pokeDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        regionViewModel = ViewModelProvider(this).get(RegionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_region, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val regionRecyclerView = regionRecyclerView
        val layoutManager = GridLayoutManager(context, 2)
        regionRecyclerView.layoutManager = layoutManager

        regionViewModel.getRegionList().observe(viewLifecycleOwner, Observer {
            val pokemonRegions: List<PokemonRegion> = it
            regionRecyclerView.adapter = RegionAdapter(pokemonRegions, view.context)
        })
    }
}