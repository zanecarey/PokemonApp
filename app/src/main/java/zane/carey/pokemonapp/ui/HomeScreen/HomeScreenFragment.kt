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
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home_screen.*
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

    private lateinit var homeScreenViewModel: HomeScreenViewModel
    private lateinit var testName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeScreenViewModel = ViewModelProvider(this).get(HomeScreenViewModel::class.java)

        testNetworkRequest()
    }

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

        homeScreenViewModel.getListMenu().observe(viewLifecycleOwner, Observer {
            val items: List<Category> = it
            categoryRecyclerView.adapter = CategoryAdapter(items, view.context)
        })
    }

    private fun testNetworkRequest() {

        val call = PokeAPI.pokemonService.getPokemon(1)
        call.enqueue(object : Callback<PokemonResults?> {

            override fun onResponse(
                call: Call<PokemonResults?>,
                response: Response<PokemonResults?>
            ) {
                response.body()?.let { pokemons: PokemonResults ->
                    thread {
                        //Toast.makeText(this, pokemons.name, Toast.LENGTH_SHORT).show()
                        testName = pokemons.name
                        test_textView.text = testName
                    }
                }
            }

            override fun onFailure(call: Call<PokemonResults?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}