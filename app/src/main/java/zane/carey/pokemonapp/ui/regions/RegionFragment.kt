package zane.carey.pokemonapp.ui.regions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.ui.items.ItemAdapter
import zane.carey.pokemonapp.ui.items.ItemViewModel

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
        return inflater.inflate(R.layout.fragment_item, container, false)
    }
}