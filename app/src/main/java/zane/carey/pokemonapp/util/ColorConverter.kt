package zane.carey.pokemonapp.util

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import zane.carey.pokemonapp.App.Companion.context
import zane.carey.pokemonapp.R

class ColorConverter(context : Context) {

    @ColorInt
    fun getColor(type: String?): Int {
        val color = when (type?.toLowerCase()) {
            "grass", "bug" -> R.color.green
            "fire" -> R.color.red
            "water", "fighting", "normal" -> R.color.blue
            "electric", "psychic" -> R.color.yellow
            "poison", "ghost" -> R.color.purple
            "ground", "rock" -> R.color.brown
            "dark" -> R.color.black
            else -> R.color.blue
        }
        return convertColor(color)
    }

    @ColorInt
    fun getLightColor(type: String?): Int {
        val color = when (type?.toLowerCase()) {
            "grass", "bug" -> R.color.light_green
            "fire" -> R.color.light_red
            "water", "fighting", "normal" -> R.color.light_blue
            "electric", "psychic" -> R.color.light_yellow
            "poison", "ghost" -> R.color.light_purple
            "ground", "rock" -> R.color.light_brown
            "dark" -> R.color.grey
            else -> R.color.blue

        }
        return convertColor(color)
    }

    @ColorInt
    fun convertColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(context, color)
    }
}