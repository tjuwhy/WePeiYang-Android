package com.example.yellowpages2.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.yellowpages2.R
import com.example.yellowpages2.YellowPagesPreference
import com.example.yellowpages2.model.Department
import com.example.yellowpages2.service.search
import com.twt.wepeiyang.commons.experimental.cache.RefreshState
import org.jetbrains.anko.coroutines.experimental.asReference

class SearchResult : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)




        val activity = this@SearchResult.asReference()
        search(""){refreshState,bean ->
            when(refreshState){
                is RefreshState.Success -> {
                    val departlist = mutableListOf<Array<Department>>()
                }
            }
        }
    }
}
