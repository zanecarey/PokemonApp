package zane.carey.pokemonapp.ui.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_item_display.*
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO

class ItemDisplay: Fragment() {

    private val pokeDao: PokeDAO = App.database.pokeDao()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemID = arguments?.getString("pokeID").toString()

        pokeDao.getItemById(itemID).observe(viewLifecycleOwner, Observer { itemValue ->
            itemName.text = itemValue.name
            itemFlavorText.text = itemValue.flavorTextEntry
            itemCost.text = itemValue.cost.toString()

        })
    }
}