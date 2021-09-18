package zane.carey.pokemonapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poke_list_item.view.*
import zane.carey.pokemonapp.App.Companion.context
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Pokemon
import zane.carey.pokemonapp.util.ColorConverter

class PokemonAdapter(private val pokeList: List<Pokemon>, private val context: Context) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindView(item: Pokemon) {

            itemView.pokemonName.text = item.name?.capitalize()
            itemView.poke_item_cardView.setOnClickListener{
                var idBundle = bundleOf("id" to item.id)

                it.findNavController()
                    .navigate(R.id.action_navigation_pokemon_to_navigation_viewpager, idBundle)
            }
            //itemView.type1.text = item.type?.get(0).toString()
            itemView.type1.text = item.type?.get(0)!!.type.name
            if(item.type!!.size >= 2){
                itemView.type2.text = item.type?.getOrNull(1)!!.type.name
            } else {
                itemView.type2.text = "-1"
                itemView.type2.visibility = View.INVISIBLE
            }

            itemView.poke_item_cardView.setCardBackgroundColor(ColorConverter(context).getColor(item.type?.get(0)!!.type.name))

            Glide.with(itemView.context)
                .load(item.sprites?.get(0))
                .placeholder(android.R.color.transparent)
                .into(itemView.pokemonImage)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.poke_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokeList[position]

        holder.bindView(item)


    }


}