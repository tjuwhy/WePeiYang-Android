package com.example.yellowpages2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.Toast
import com.twt.wepeiyang.commons.experimental.extensions.bindNonNull

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var handler: Handler
    lateinit var searchIcon: ImageView
//    var mProgressDialog = ProgressDialog(this)

    private val groupData = arrayOf(GroupData("1",0),GroupData("2",1),GroupData("3",2))

    private val childData = arrayOf(arrayOf(SubData("11",0,0, ITEM_COLLECTION,"12345678"),SubData("12",0,1, ITEM_COLLECTION,"123456789"),SubData("13",0,2, ITEM_COLLECTION,"23568564")),
            arrayOf(SubData("21",1,0),SubData("22",1,1),SubData("23",0,2))
            , arrayOf(SubData("31",2,0),SubData("32",2,1),SubData("33",2,2)))


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yellow_page)
        searchIcon = findViewById(R.id.yellow_page_search)
        recyclerView = findViewById(R.id.phone_rv)
        recyclerView.layoutManager = LinearLayoutManager(this)
        ExpandableHelper(recyclerView,groupData,childData)
        yellowPageLiveData.bindNonNull(this){
            Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
        }
        searchIcon.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private val childDatas = mutableListOf<Array<SubData>>()

    private fun dataConvertToRecyclerView(phoneBean: PhoneBean){

    }
//
//    private fun showInitDialog() {
//        val msg = "首次使用，需要导入号码库，请等待..."
//        updateProgressDialogStatus(-10)
//        mProgressDialog.setCancelable(false)
//        mProgressDialog.setTitle("提示")
//        mProgressDialog.setMessage(msg)
//        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
//        mProgressDialog.max = 100
//        mProgressDialog.setCanceledOnTouchOutside(false)
    //        mProgressDialog.show()
//    }
//
//    private fun updateProgressDialogStatus(what: Int) {
//            if (what == -1) {
//                mProgressDialog.dismiss()
//            } else {
//                mProgressDialog.incrementProgressBy(what)
//            }
//    }

}
