package zane.carey.pokemonapp.ui.items


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_view.view.*
import zane.carey.pokemonapp.App.Companion.context
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.model.PokeItem

class ItemAdapter(private val pokeItemList: List<PokeItem>, private val context: Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(pokeItem: PokeItem) {
            itemView.itemName.text = pokeItem.name
            itemView.item_cardView.setOnClickListener {
                var idBundle = bundleOf("pokeID" to pokeItem.id)

                it.findNavController()
                    .navigate(R.id.action_navigation_poke_item_to_navigation_item_display, idBundle)
            }
            Glide.with(itemView.context)
                .load(pokeItem.sprites?.get(0))
                .placeholder(android.R.color.transparent)
                .into(itemView.itemImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokeItemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokeItemList[position]
        holder.bindView(item)
    }
}
