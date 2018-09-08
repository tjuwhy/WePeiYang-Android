package com.example.yellowpages2

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import com.twt.wepeiyang.commons.experimental.cache.RefreshState
import com.twt.wepeiyang.commons.experimental.extensions.fitSystemWindowWithStatusBar
import es.dmoral.toasty.Toasty
import org.jetbrains.anko.coroutines.experimental.asReference

class HomeActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    private val groupArray = arrayOf("我的收藏", "校级部门", "院级部门", "其他部门")
    lateinit var recyclerView: RecyclerView
    lateinit var searchIcon: ImageView
    private var groupCount = 0

    private val groupData = groupArray.map { GroupData(it, groupCount++) }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yellow_page)

        searchIcon = findViewById(R.id.yellow_page_search)

        recyclerView = findViewById(R.id.phone_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val activity = this@HomeActivity.asReference()
        getPhone { }
        getUserCollection { refreshState ->
            when (refreshState) {
                is RefreshState.Success -> {
                    val childDatas = mutableListOf<Array<SubData>>()
                    childDatas.add(YellowPagePreference.collectionList)
                    childDatas.addAll(YellowPagePreference.subArray)
                    ExpandableHelper(this, recyclerView, groupData.toTypedArray(), childDatas.toTypedArray())
                }
                is RefreshState.Failure -> {
                    Toasty.error(activity(), "发生错误").show()
                }
            }
        }

        searchIcon.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }


}
