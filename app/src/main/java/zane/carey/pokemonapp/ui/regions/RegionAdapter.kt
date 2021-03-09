package zane.carey.pokemonapp.ui.regions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_view.view.*
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.PokemonRegion

class RegionAdapter(private val pokemonRegionList: List<PokemonRegion>, private val context: Context) : RecyclerView.Adapter<RegionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(pokemonRegion: PokemonRegion) {
            itemView.itemName.text = pokemonRegion.name
            itemView.setOnClickListener {
                var idBundle = bundleOf("id" to pokemonRegion.id)

                it.findNavController()
                    .navigate(R.id.action_navigation_poke_item_to_navigation_item_display, idBundle)

//                Glide.with(itemView.context)
//                    .load(region.sprites?.get(0))
//                    .placeholder(android.R.color.transparent)
//                    .into(itemView.itemImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(App.context).inflate(R.layout.item_list_view, parent, false)

        return RegionAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokemonRegionList[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return pokemonRegionList.size
    }
}