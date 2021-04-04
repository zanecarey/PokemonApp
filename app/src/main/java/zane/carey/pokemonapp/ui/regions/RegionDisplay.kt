package zane.carey.pokemonapp.ui.regions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_move_display.*
import kotlinx.android.synthetic.main.fragment_move_display.moveName
import kotlinx.android.synthetic.main.fragment_region_display.*
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO

class RegionDisplay: Fragment() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    val regionID = arguments?.getString("id")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_region_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokeDao.getRegionById(regionID).observe(viewLifecycleOwner, Observer { regionValue ->
            regionName.text = regionValue.name
            regionLocation.text = regionValue.location.toString()
            regionGeneration.text = regionValue.main_generation

        })
    }
}