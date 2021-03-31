package zane.carey.pokemonapp.ui.HomeScreen

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_list_item.view.*
import zane.carey.pokemonapp.App.Companion.context
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Category
import java.util.*

class CategoryAdapter(
    private val categories: List<Category>,
    private val context: Context
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Category) {

            itemView.categoryName.text = item.name


            itemView.setOnClickListener {
                if(item.id == 1){//Pokedex

                    it.findNavController().navigate(R.id.action_navigation_main_to_navigation_pokemon)
                } else if(item.id == 2){//Generation

                } else if(item.id == 3){//Types
                    it.findNavController().navigate(R.id.action_navigation_main_to_navigation_types)

                } else if(item.id == 4){//Locations
                    it.findNavController().navigate(R.id.action_navigation_main_to_navigation_poke_regions)
                } else if(item.id == 5){//Moves
                    it.findNavController().navigate(R.id.action_navigation_main_to_navigation_poke_moves)
                } else if(item.id == 6){//Items
                    it.findNavController().navigate(R.id.action_navigation_main_to_navigation_poke_item)
                }


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categories[position]
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, item.color))
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
