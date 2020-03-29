package me.slaheddine.leboncoin.presentation.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.slaheddine.leboncoin.R

class AlbumListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, AlbumListFragment.newInstance())
                    .commitNow()
        }
    }
}
