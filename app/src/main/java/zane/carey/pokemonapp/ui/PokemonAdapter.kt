package zane.carey.pokemonapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(val context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate())
    }

    override fun getItemCount(): Int {
        return
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}