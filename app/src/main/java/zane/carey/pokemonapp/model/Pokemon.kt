package zane.carey.pokemonapp.model

import androidx.annotation.NonNull
import androidx.room.*

import retrofit2.Converter
import zane.carey.pokemonapp.util.StringConverter


@Entity
 data class Pokemon (

    @PrimaryKey
    @NonNull
    var id: String,
    var name: String? = null,
    var height: Int? = null,
    var weight: Int? = null,
    var baseXP: Int? = null,
    var attack: Int? = null,
    var health: Int? = null,
    var defense: Int? = null,
    var spAttack: Int? = null,
    var spDefense: Int? = null,
    var speed: Int? = null,
    var gender: String? = null,
    var flavorText: String? = null
    //var type: List<String>? = null,
    //var evolutionChain: List<String>? = null,
    //var sprites: List<String>? = null,
    //var abilities: List<String>? = null,
    //var moves: List<String>? = null
)
