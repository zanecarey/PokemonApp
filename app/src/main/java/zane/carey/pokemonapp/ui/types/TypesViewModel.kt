package zane.carey.pokemonapp.ui.types

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Category
import zane.carey.pokemonapp.model.Type

class TypesViewModel : ViewModel() {

    private val listTypes = MutableLiveData<List<Type>>()

    fun getListTypes(): LiveData<List<Type>> {
        listTypes.value = listOf(
            Type(1, "Fire", R.color.red),
            Type(1, "Water", R.color.green),
            Type(1, "Earth", R.color.blue),
            Type(1, "Psychic", R.color.orange)
        )
        return listTypes
    }
}

