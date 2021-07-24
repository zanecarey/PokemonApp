package zane.carey.pokemonapp.util

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import zane.carey.pokemonapp.repository.PokemonType
import java.lang.reflect.Type

class StringConverter {
    val gson = Gson()
    val type: Type = object : TypeToken<List<String?>?>() {}.type
    val type2: Type = object : TypeToken<List<PokemonType?>?>() {}.type

    @TypeConverter
    fun fromString(json: String?): List<String> {
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun fromList(list: List<String?>?): String {
        return gson.toJson(list, type)
    }

    @TypeConverter
    fun fromTypeString(json: String?): List<PokemonType> {
        return gson.fromJson(json, type2)
    }

    @TypeConverter
    fun fromTypeList(list: List<PokemonType?>?): String {
        return gson.toJson(list, type2)
    }
}