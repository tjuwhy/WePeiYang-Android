package com.example.yellowpages2.view


import android.content.Intent
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
import com.example.yellowpages2.R
import com.example.yellowpages2.utils.ItemAdapter
import com.example.yellowpages2.utils.ItemManager
import com.example.yellowpages2.utils.YellowPagePreference
import com.example.yellowpages2.utils.withItems
import java.lang.reflect.Method


//import scut.carson_ho.searchview.SearchView

@Suppress("UNREACHABLE_CODE")
class SearchActivity : AppCompatActivity() {
    lateinit var itemManager: ItemManager
    lateinit var mSearchView: SearchView
    lateinit var recyclerView: RecyclerView
    lateinit var mToolbar: Toolbar
    lateinit var footer: TextView
    val mSearchAutoComplete: SearchView.SearchAutoComplete? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        mToolbar = this.findViewById(R.id.sear_toolbar)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        footer = this.findViewById(R.id.item_search_delete_all)
        recyclerView = this.findViewById(R.id.recyclerview_search)
        recyclerView.withItems(YellowPagePreference.historyList.map { it -> SearchHistoryItem(it) })
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemManager = ItemManager()
        recyclerView.adapter = ItemAdapter(itemManager)
        footer.setOnClickListener {
            YellowPagePreference.historyList.clear()
            itemManager.refreshAll(YellowPagePreference.historyList.map { it -> SearchHistoryItem(it) })
            footer.visibility = View.INVISIBLE

            mToolbar.setNavigationOnClickListener {
                if (mSearchAutoComplete!!.isShown) {
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
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_view, menu)
        val searchItem: MenuItem = menu!!.findItem(R.id.menu_search)
//        val searchViewButton: MenuItem =menu.findItem(R.id.menu_search)
        mSearchView = MenuItemCompat.getActionView(searchItem) as SearchView
        //  mSearchView.setIconifiedByDefault(false)
        mSearchView.onActionViewExpanded()
        mSearchView.isIconified = false
        mSearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("--log", "QueryTextChange: " + newText)
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                val intent = Intent(this@SearchActivity, SearchResultActivity::class.java)
                intent.putExtra("query", query)
                startActivity(intent)

                YellowPagePreference.historyList.add(0, query!!)
                footer.visibility = View.VISIBLE
                itemManager.refreshAll(YellowPagePreference.historyList.map { it -> SearchHistoryItem(it) })
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }
}