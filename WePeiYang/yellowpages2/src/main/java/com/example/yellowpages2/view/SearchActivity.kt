package com.example.yellowpages2.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.yellowpages2.R
import com.example.yellowpages2.utils.*

class SearchActivity : AppCompatActivity() {

    var items = mutableListOf<Item>()
    private lateinit var arrowBack : ImageView
    val itemManager = ItemManager()
    lateinit var editText: EditText
    lateinit var iconSearch : ImageView
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        arrowBack = findViewById(R.id.search_arrow_back)
        editText = findViewById(R.id.search_edit)
        iconSearch = findViewById(R.id.search_search_icon)

        recyclerView = findViewById(R.id.search_history_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(itemManager)
        recyclerView.withItems(YellowPagePreference.seachHistory.map{ t -> SearchHistoryItem(this,t){ search(t) } })
        if (YellowPagePreference.seachHistory.size > 0){
            itemManager.add(SingleTextItem("清空历史"){clearHistory()})
        }

        arrowBack.setOnClickListener {
            onBackPressed()
        }
        editText.setOnEditorActionListener{ _, actionId, event ->
            var flag = true
            if (actionId == EditorInfo.IME_ACTION_SEND||event?.keyCode == KeyEvent.KEYCODE_ENTER ){
                search(editText.text.trim().toString())
            } else {
                flag = false
            }
            flag
        }
        iconSearch.setOnClickListener {
            search(editText.text.trim().toString())
        }


    }

    private fun search(text : String){
        if (text != ""){
            YellowPagePreference.seachHistory.remove(text)
            YellowPagePreference.seachHistory.add(text)
            items = YellowPagePreference.seachHistory.reversed().map { it -> SearchHistoryItem(this,it){search(it)} }.toMutableList()
            if (YellowPagePreference.seachHistory.size != 0){
                items.add(SingleTextItem("清空历史"){clearHistory()})
            }
            recyclerView.withItems(items)
            val intent = Intent(this , SearchResultActivity::class.java)
            intent.putExtra("search_content",text)
            editText.setText("")
            startActivity(intent)
        } else {
            Toast.makeText(this,"请输入搜索内容",Toast.LENGTH_SHORT).show()
        }
    }

    private fun clearHistory(){
        items.clear()
        YellowPagePreference.seachHistory.clear()
        recyclerView.withItems(items)
    }
}

