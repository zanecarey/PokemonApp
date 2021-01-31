package zane.carey.pokemonapp.ui.items

import PokeItem
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import zane.carey.pokemonapp.R

class ItemAdapter(private val pokeItemList: List<PokeItem>, private val context: Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(pokeItem: PokeItem) {
//            itemViem.itemName.text = item.name
//            itemView.setOnClickListener{
//                var idBundle = bundleOf("id" to item.id)
//
//                it.findNavController()
//                    .navigate(R.id.action_navigation_pokemon_to_navigation_viewpager, idBundle)
//
//            Glide.with(itemView.context)
//                .load(item.sprites?.get(0))
//                .placeholder(android.R.color.transparent)
//                .into(itemView.pokemonImage)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false)

        return ItemAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokeItemList[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return pokeItemList.size
    }


}
