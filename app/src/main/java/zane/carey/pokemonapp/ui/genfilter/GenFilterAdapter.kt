package zane.carey.pokemonapp.ui.genfilter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_generation.view.*
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Generation
import zane.carey.pokemonapp.ui.PokemonAdapter

class GenFilterAdapter(private val list: List<Generation>, private val context: Context): RecyclerView.Adapter<GenFilterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenFilterAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_generation, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Generation) {
            itemView.generationTitle.text = item.title
            itemView.generationImageView.setImageResource(item.image)
        }
    }
}