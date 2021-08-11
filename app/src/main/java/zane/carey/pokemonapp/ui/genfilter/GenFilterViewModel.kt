package zane.carey.pokemonapp.ui.genfilter

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Generation

class GenFilterViewModel(private val context: Context) : ViewModel() {

    private val listGeneration = MutableLiveData<List<Generation>>()

    fun getListGeneration(): LiveData<List<Generation>> {
        listGeneration.value = listOf(
            Generation(
                1,
                context.resources.getString(R.string.gen1),
                R.drawable.gen1
            ),
            Generation(
                1,
                context.resources.getString(R.string.gen2),
                R.drawable.gen2
            ),
            Generation(
                1,
                context.resources.getString(R.string.gen3),
                R.drawable.gen3
            ),
            Generation(
                1,
                context.resources.getString(R.string.gen4),
                R.drawable.gen4
            ),
            Generation(
                1,
                context.resources.getString(R.string.gen5),
                R.drawable.gen5
            ),
            Generation(
                1,
                context.resources.getString(R.string.gen6),
                R.drawable.gen6
            ),
            Generation(
                1,
                context.resources.getString(R.string.gen7),
                R.drawable.gen7
            ),
            Generation(
                1,
                context.resources.getString(R.string.gen8),
                R.drawable.gen8
            )
        )
        return listGeneration
    }
}