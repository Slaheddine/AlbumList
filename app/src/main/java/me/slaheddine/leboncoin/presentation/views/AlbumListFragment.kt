package me.slaheddine.leboncoin.presentation.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.main_fragment.*
import me.slaheddine.leboncoin.R
import me.slaheddine.leboncoin.presentation.adapter.AlbumsRecyclerAdapter
import me.slaheddine.leboncoin.presentation.adapter.OnItemClickListener
import me.slaheddine.leboncoin.presentation.models.AlbumItem
import me.slaheddine.leboncoin.presentation.viewmodels.AlbumViewModel
import org.koin.android.ext.android.inject

class AlbumListFragment : Fragment() {

    companion object {
        fun newInstance() =
            AlbumListFragment()
    }

    private val viewModel by inject<AlbumViewModel>()
    lateinit var albumListAdapter: AlbumsRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView();
        viewModel.loadAlbums();
    }

    fun initView() {

        initRecycleView()

        viewModel.albumListLiveData.observe(viewLifecycleOwner, Observer { result : List<AlbumItem> ->
            manageDataResponse(result)
        })

        viewModel.failure.observe(viewLifecycleOwner, Observer { result : Unit ->
            manageFailureResponse()
        })

        progressBar.visibility = View.VISIBLE
    }

    fun initRecycleView() {
        albumsRecyclerView.layoutManager = LinearLayoutManager(activity)

        albumListAdapter = AlbumsRecyclerAdapter(object : OnItemClickListener {
            override fun onItemClick(album: AlbumItem) {
               // open detail
            }
        })

        albumsRecyclerView.adapter = albumListAdapter

        val dividerItemDecoration = DividerItemDecoration(
            activity,
            LinearLayoutManager.VERTICAL
        )

        albumsRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    fun manageDataResponse(stations  : List<AlbumItem>) {
        progressBar.visibility = View.GONE
        albumListAdapter.addAlbumssList(stations)
    }

    fun manageFailureResponse() {
        progressBar.visibility = View.GONE
    }

}
