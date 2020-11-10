package zane.carey.pokemonapp.ui.types

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_list_item.view.*
import zane.carey.pokemonapp.App.Companion.context
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Category
import zane.carey.pokemonapp.model.Type
import zane.carey.pokemonapp.ui.HomeScreen.CategoryAdapter

class TypesAdapter(val types: List<Type>, val context: Context) : RecyclerView.Adapter<TypesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: Type) {
            itemView.categoryName.text = item.name

            itemView.setOnClickListener {
                if (item.id == 1) {//Fire

                    it.findNavController()
                        .navigate(R.id.action_navigation_main_to_navigation_pokemon)
                } else if (item.id == 2) {//Water

                } else if (item.id == 3) {//Grass

                } else if (item.id == 4) {//Flying

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.types_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = types[position]
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return types.size
    }
}