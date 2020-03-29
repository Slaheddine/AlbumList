package me.slaheddine.leboncoin.presentation.views

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.slaheddine.leboncoin.R
import me.slaheddine.leboncoin.presentation.viewmodels.AlbumViewModel

class AlbumListFragment : Fragment() {

    companion object {
        fun newInstance() =
            AlbumListFragment()
    }

    private lateinit var viewModel: AlbumViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AlbumViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
