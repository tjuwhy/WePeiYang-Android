package com.example.yellowpages2.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.view.Menu
import com.example.yellowpages2.R
import scut.carson_ho.searchview.SearchView

class SearchActivity : AppCompatActivity() {

    lateinit var mSearchView:SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
//        searchView = findViewById(R.id.yellow_page_search_view)
//        searchView
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_view,menu)
        val searchItem = menu?.findItem(R.id.menu_search)
        mSearchView = MenuItemCompat.getActionView(searchItem) as SearchView
        return super.onCreateOptionsMenu(menu)
    }
}
