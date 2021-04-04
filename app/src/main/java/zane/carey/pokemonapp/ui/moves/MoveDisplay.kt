package zane.carey.pokemonapp.ui.moves

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_move_display.*
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.database.PokeDAO

class MoveDisplay: Fragment() {

    private val pokeDao: PokeDAO = App.database.pokeDao()

    val moveID = arguments?.getString("id")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_move_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokeDao.getItemById(moveID).observe(viewLifecycleOwner, Observer { moveValue ->
            moveName.text = moveValue.name
            moveFlavorText.text = moveValue.flavorTextEntry
            moveCategory.text = moveValue.category

        })
    }
}