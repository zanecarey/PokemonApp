package zane.carey.pokemonapp.ui.HomeScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home_screen.*
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Category
import zane.carey.pokemonapp.repository.PokeAPI
import zane.carey.pokemonapp.repository.PokemonResults
import zane.carey.pokemonapp.ui.PokemonViewModel
import zane.carey.pokemonapp.ui.ViewPager.ViewPagerViewModel
import java.util.*
import kotlin.concurrent.thread

class HomeScreenFragment: Fragment() {

    private val hSViewModel: HomeScreenViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoryRecyclerView = categoryRecyclerView

        categoryRecyclerView.layoutManager = GridLayoutManager(context, 2)

        hSViewModel.getListMenu().observe(viewLifecycleOwner, Observer {
            val items: List<Category> = it
            categoryRecyclerView.adapter = CategoryAdapter(items, view.context)
        })

    }
}