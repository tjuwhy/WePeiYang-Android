package com.example.yellowpages2


import android.os.Bundle
import android.support.v4.view.MenuItemCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import java.lang.reflect.Method


//import scut.carson_ho.searchview.SearchView

@Suppress("UNREACHABLE_CODE")
class SearchActivity : AppCompatActivity() {
    lateinit var itemManager: ItemManager
    lateinit var mSearchView: SearchView
    lateinit var recyclerView: RecyclerView
    lateinit var mToolbar: Toolbar
    lateinit var footer: TextView
    lateinit var mSearchAutoComplete: SearchView.SearchAutoComplete
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        mToolbar = this.findViewById(R.id.sear_toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        footer = this.findViewById(R.id.item_search_delete_all)
        recyclerView = this.findViewById(R.id.recyclerview_search)
        recyclerView.withItems(YellowPagesPreference.historyList.map { it -> SearchHistoryItem(it) })
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemManager = ItemManager()
        recyclerView.adapter = ItemAdapter(itemManager)
        footer.setOnClickListener {
            YellowPagesPreference.historyList.clear()
            itemManager.refreshAll(YellowPagesPreference.historyList.map { it -> SearchHistoryItem(it) })
            footer.visibility = View.INVISIBLE
        }
        mToolbar.setNavigationOnClickListener {
            if (mSearchAutoComplete.isShown) {
                try {
                    mSearchAutoComplete.setText("")
                    val method: Method = mSearchView.javaClass.getDeclaredMethod("onCloseClicked")
                    method.isAccessible = true
                    method.invoke(mSearchView)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                finish()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_view,menu)
        val searchItem: MenuItem = menu!!.findItem(R.id.menu_search)
        mSearchView = MenuItemCompat.getActionView(searchItem) as SearchView
        mSearchView.setIconifiedByDefault(false)
        mSearchView.onActionViewExpanded()
        mSearchView.isIconified = false
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("--log", "QueryTextChange: " + newText)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                YellowPagesPreference.historyList.add(0, query!!)
                footer.visibility = View.VISIBLE
                itemManager.refreshAll(YellowPagesPreference.historyList.map { it -> SearchHistoryItem(it) })
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}
