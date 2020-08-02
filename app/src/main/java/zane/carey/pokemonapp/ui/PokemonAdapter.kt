package zane.carey.pokemonapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.poke_list_item.view.*
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Pokemon

class PokemonAdapter(val pokeList: List<Pokemon>, val context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.poke_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.pokemonName
        val type1 = view.type1
        val type2 = view.type2
    }
}