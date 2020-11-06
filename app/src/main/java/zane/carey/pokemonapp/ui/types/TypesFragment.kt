package zane.carey.pokemonapp.ui.types

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home_screen.*
import kotlinx.android.synthetic.main.fragment_home_screen.categoryRecyclerView
import kotlinx.android.synthetic.main.fragment_pokemon.*
import kotlinx.android.synthetic.main.fragment_types.*
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Category
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.model.Type
import zane.carey.pokemonapp.ui.HomeScreen.CategoryAdapter
import zane.carey.pokemonapp.ui.PokemonAdapter
import zane.carey.pokemonapp.ui.PokemonViewModel

class TypesFragment: Fragment() {

    private lateinit var typesViewModel: TypesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        typesViewModel = ViewModelProvider(this).get(TypesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_types, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val typesRecyclerView = typesRecyclerView

        typesRecyclerView.layoutManager = GridLayoutManager(context, 2)

        typesViewModel.getListTypes().observe(viewLifecycleOwner, Observer {
            val items: List<Type> = it
            typesRecyclerView.adapter = TypesAdapter(items, view.context)
        })
    }
}