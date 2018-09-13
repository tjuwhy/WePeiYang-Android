package com.example.yellowpages2.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import com.example.yellowpages2.*
import com.example.yellowpages2.model.Unit
import com.example.yellowpages2.utils.YellowPagePreference
import com.example.yellowpages2.utils.withItems

class DepartmentActivity : AppCompatActivity() {

    lateinit var title: String
    private lateinit var unitList: List<Unit>
    private lateinit var iconSearch: ImageView
    private lateinit var arrowBack: ImageView
    private lateinit var departmentTv: TextView
    lateinit var recyclerView: RecyclerView
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)

        toolbar = findViewById(R.id.toolbar)
        arrowBack = findViewById(R.id.department_arrow_back)
        iconSearch = findViewById(R.id.department_search_icon)
        departmentTv = findViewById(R.id.department_name)
        recyclerView = findViewById(R.id.recycler_view_department)

        val firstIndex = intent.getIntExtra("first_index", 0)
        val secondIndex = intent.getIntExtra("second_index", 0)

        title = YellowPagePreference.phoneBean!!.category_list[firstIndex].department_list[secondIndex].department_name
        unitList = YellowPagePreference.phoneBean!!.category_list[firstIndex].department_list[secondIndex].unit_list
        departmentTv.text = title
        arrowBack.setOnClickListener {
            onBackPressed()
        }
        iconSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.withItems(unitList.map { unit ->
            var flag = false
            YellowPagePreference.collectionList.forEach {
                if (it.thirdId == unit.id) {
                    flag = true
                }
            }
            ChildItem(this, unit.item_name, unit.item_phone, flag, unit.id)
        })
    }
}
