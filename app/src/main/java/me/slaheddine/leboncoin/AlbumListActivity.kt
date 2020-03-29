package me.slaheddine.leboncoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.slaheddine.leboncoin.ui.main.AlbumListFragment

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
