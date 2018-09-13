package com.example.yellowpages2.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.yellowpages2.R
import com.example.yellowpages2.service.search

class SearchResultActivity : AppCompatActivity() {

    lateinit var keyWord : String
    lateinit var arrowBackIv : ImageView
    lateinit var editText: EditText
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        keyWord = intent.getStringExtra("search_content")

        arrowBackIv = findViewById(R.id.search_result_arrow_back)
        editText = findViewById(R.id.search_result_edit)

        editText.setText(keyWord)
        search(keyWord){ refreshState, bean ->

        }

        arrowBackIv.setOnClickListener {
            onBackPressed()
        }
        editText.setOnClickListener {
            val intent = Intent(this,SearchActivity::class.java)
            intent.putExtra("search_content",keyWord)
            startActivity(intent)
        }
        Toast.makeText(this,keyWord,Toast.LENGTH_SHORT).show()

    }
}
