package zane.carey.pokemonapp.ui.ViewPager

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import zane.carey.pokemonapp.App
import zane.carey.pokemonapp.database.PokeDAO
import zane.carey.pokemonapp.model.Pokemon

class ViewPagerViewModel : ViewModel(){

    private val pokeDao: PokeDAO = App.database.pokeDao()

    fun getById(id: String?) : LiveData<Pokemon> {
        return pokeDao.getById(id)
    }
    fun getByName(name: String?) : LiveData<Pokemon> {
        return pokeDao.getByName(name)
    }
}