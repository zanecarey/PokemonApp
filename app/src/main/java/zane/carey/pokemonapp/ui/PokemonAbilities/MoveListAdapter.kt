package zane.carey.pokemonapp.ui.PokemonAbilities

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.move_list_item.view.*
import zane.carey.pokemonapp.R

class MoveListAdapter(private val moveList: List<String?>?, private val context: Context) : RecyclerView.Adapter<MoveListAdapter.ViewHolder>(){

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindView(move: String?){

            itemView.moveName.text = move
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MoveListAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.move_list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val move = moveList?.get(position)

        holder.bindView(move)
    }

    override fun getItemCount(): Int {
        return moveList!!.size
    }
}