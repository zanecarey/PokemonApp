package zane.carey.pokemonapp.ui.moves

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list_view.view.*
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.model.PokemonMove
import zane.carey.pokemonapp.ui.items.ItemAdapter

class MoveAdapter(private val moveList: List<PokemonMove>, private val context: Context) : RecyclerView.Adapter<MoveAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(pokemonMove: PokemonMove) {
            itemView.itemName.text = pokemonMove.name
            itemView.setOnClickListener {
                var idBundle = bundleOf("id" to pokemonMove.id)

                it.findNavController()
                    .navigate(R.id.action_navigation_poke_item_to_navigation_item_display, idBundle)

//                Glide.with(itemView.context)
//                    .load(pokemonMove.sprites?.get(0))
//                    .placeholder(android.R.color.transparent)
//                    .into(itemView.itemImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_view, parent, false)

        return MoveAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = moveList[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return moveList.size
    }

}