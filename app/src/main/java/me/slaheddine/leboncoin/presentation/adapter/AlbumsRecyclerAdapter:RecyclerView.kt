package me.slaheddine.leboncoin.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.album_item.view.*
import me.slaheddine.leboncoin.R
import me.slaheddine.leboncoin.presentation.models.AlbumItem

class AlbumsRecyclerAdapter(private val onItemClickListener: OnItemClickListener):RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listOfAlbums = arrayListOf<AlbumItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AlbumRecycleViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.album_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = listOfAlbums.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val albumViewHolder = viewHolder as AlbumRecycleViewHolder
        albumViewHolder.bindView(listOfAlbums[position], onItemClickListener)
    }

    fun addAlbumssList(newList: List<AlbumItem>?) {
        if ((newList!=null)&&(newList?.size > 0)) {
            var oldSize = listOfAlbums.size
            listOfAlbums.addAll(newList)
            var sizeNew = listOfAlbums.size
            notifyItemRangeInserted(oldSize, sizeNew)
        }
    }

    fun clear() {
        listOfAlbums.clear()
        notifyDataSetChanged();
    }
}

class AlbumRecycleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(albumItem: AlbumItem, onItemClickListener : OnItemClickListener) {
        itemView.title.text = albumItem.title
        itemView.setOnClickListener(View.OnClickListener {
            onItemClickListener.onItemClick(albumItem)
        })
    }
}

interface OnItemClickListener {
    fun onItemClick(albumItem : AlbumItem)
}