package com.example.yellowpages2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import android.widget.Toast

class DepartmentActivity : AppCompatActivity() {

    lateinit var title : String
    lateinit var unitList: List<Unit>
    lateinit var departmentTv : TextView
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_department)
        val firstIndex = intent.getIntExtra("first_index",0)
        val secondIndex = intent.getIntExtra("second_index",0)
        title = YellowPagePreference.phoneBean!!.category_list[firstIndex].department_list[secondIndex].department_name
        unitList = YellowPagePreference.phoneBean!!.category_list[firstIndex].department_list[secondIndex].unit_list
        departmentTv = findViewById(R.id.department_name)
        recyclerView = findViewById(R.id.recycler_view_department)
        departmentTv.text = title
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.withItems(unitList.map {unit ->
            var flag = false
            YellowPagePreference.collectionList.forEach {
                if (it.thirdId == unit.id){
                    flag = true
                }
            }
            ChildItem(this,unit.item_name,unit.item_phone,flag,unit.id)
        })
    }
}
