package zane.carey.pokemonapp.ui.genfilter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_gen_filter.*
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel
import org.koin.android.viewmodel.ext.android.viewModel
import zane.carey.pokemonapp.R
import zane.carey.pokemonapp.model.Generation

class GenFilterFragment: BottomSheetDialogFragment() {

    private val genFilterViewModel: GenFilterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gen_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rV = genFilterRecyclerView
        val layoutManager = GridLayoutManager(context, 2)
        rV.layoutManager = layoutManager

        genFilterViewModel.getListGeneration().observe(viewLifecycleOwner, Observer {
            val pokemons: List<Generation> = it
            rV.adapter = GenFilterAdapter(pokemons, view.context)
        })
    }
}