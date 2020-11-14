package zane.carey.pokemonapp.ui.ViewPager

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.appbar.AppBarLayout
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.ui.PokemonAbilities.AbilitiesFragment
import zane.carey.pokemonapp.ui.PokemonBio.BioFragment
import zane.carey.pokemonapp.ui.PokemonEvolutions.EvolutionFragment
import zane.carey.pokemonapp.ui.PokemonStats.StatsFragment

class ViewPagerAdapter (
    supportFragmentManager: FragmentManager,
    context: Context,
    private val pokemonId: String
): FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){


    private val pages = listOf(
        Page(
            context.getString(R.string.bio)
        ) { BioFragment.newInstance(pokemonId) },
        Page(
            context.getString(R.string.stats)
        ) { StatsFragment.newInstance(pokemonId) },
        Page(
            context.getString(R.string.evolutions)
        ) { EvolutionFragment() },
        Page(
            context.getString(R.string.abilities)
        ) { AbilitiesFragment() }
    )

    override fun getCount(): Int {
        return pages.size
    }

    override fun getItem(position: Int): Fragment {
        return pages[position].fragmentName()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pages[position].pageTitle
    }

    data class Page(val pageTitle: String, val fragmentName:()-> Fragment)
}