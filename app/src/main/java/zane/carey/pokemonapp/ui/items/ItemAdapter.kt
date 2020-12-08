package zane.carey.pokemonapp.ui.items

import Item
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poke_list_item.view.*
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonAdapter

class ItemAdapter(private val itemList: List<Item>, private val context: Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: Item) {
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
        val item = itemList[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


}
}