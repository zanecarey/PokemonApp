package zane.carey.pokemonapp.ui.generation

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
import zane.carey.pokemonapp.model.PokeGeneration
import zane.carey.pokemonapp.model.PokeItem
import zane.carey.pokemonapp.ui.items.ItemAdapter

class GenerationAdapter(private val genList: List<PokeGeneration>, private val context: Context) : RecyclerView.Adapter<GenerationAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(pokeGen: PokeGeneration) {
            itemView.itemName.text = pokeGen.name
            itemView.setOnClickListener {
                var idBundle = bundleOf("id" to pokeGen.id)

                it.findNavController()
                    .navigate(R.id.action_navigation_poke_item_to_navigation_item_display, idBundle)

//                Glide.with(itemView.context)
//                    .load(pokeItem.sprites?.get(0))
//                    .placeholder(android.R.color.transparent)
//                    .into(itemView.itemImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(App.context).inflate(R.layout.gen_list_item, parent, false)

        return GenerationAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gen = genList[position]
        holder.bindView(gen)
    }

    override fun getItemCount(): Int {
        return genList.size
    }

}