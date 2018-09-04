package com.example.yellowpages2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ExpandableListView

class HomeActivity : AppCompatActivity() {

    val groupStrings = arrayOf("校级部门","院级部门","校级部门","校级部门","院级部门")
    lateinit var recyclerView: RecyclerView

    private val groupData = arrayOf(GroupData("1",0),GroupData("2",1),GroupData("3",2))

    private val childData = arrayOf(arrayOf(ChildData("11",false,0,0),ChildData("12",false,0,1),ChildData("13",false,0,2)),
            arrayOf(ChildData("21",false,1,0),ChildData("22",false,1,1),ChildData("23",false,0,2))
            , arrayOf(ChildData("31",false,2,0),ChildData("32",false,2,1),ChildData("33",false,2,2)))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerView = findViewById(R.id.phone_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        ExpandableHelper(recyclerView,groupData,childData)
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.add(R.id.expand_list_container,ExpandListContainerFragment())
//        fragmentTransaction.commit()
    }
}
