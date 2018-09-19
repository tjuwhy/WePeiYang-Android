package com.example.yellowpages2.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.example.yellowpages2.R
import com.example.yellowpages2.model.Department
import com.example.yellowpages2.model.Item
import com.example.yellowpages2.service.search
import com.example.yellowpages2.utils.ItemAdapter
import com.example.yellowpages2.utils.ItemManager
import com.example.yellowpages2.utils.YellowPagePreference
import com.example.yellowpages2.utils.withItems
import com.twt.wepeiyang.commons.experimental.cache.RefreshState
import es.dmoral.toasty.Toasty
import org.jetbrains.anko.coroutines.experimental.asReference


class SearchResultActivity : AppCompatActivity() {
    val titleList = mutableListOf<Department>()
    val subList = mutableListOf<Array<String>>()
    lateinit var recyclerView: RecyclerView
    lateinit var itemManager: ItemManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        recyclerView = this.findViewById(R.id.sear_result_rec)
        recyclerView.layoutManager = LinearLayoutManager(this)
        itemManager = ItemManager()
        recyclerView.adapter = ItemAdapter(itemManager)
        val activity = this@SearchResultActivity.asReference()
        val intent: Intent = getIntent()
        val query: String = intent.getStringExtra("query")
        val textView = findViewById<TextView>(R.id.sear_result_toolbar_text)
        textView.setText(query)
        search(query) { refreshState, bean ->
            when (refreshState) {
                is RefreshState.Success -> {
                    if (bean != null) {
                        val itemTempList = bean.item.toMutableList()
                        var departmentList = bean.department.toMutableList()
                        val recyclerItems = mutableListOf<com.example.yellowpages2.utils.Item>()
                        var item: Item? = null
                        departmentList.forEach { department ->
                            titleList.add(department)
                            subList.add(itemTempList.filter {
                                var flag = it.item_attach == department.id.toString()
                                if (flag) {
                                    item = it
                                }
                                flag
                            }
                                    .map { it.item_name }
                                    .toTypedArray())
                            itemTempList.remove(item)
                        }

                        var oldSecond = -1
                        var newSecond: Int
                        var index = 0
                        val subTempList = mutableListOf<String>()
                        itemTempList.forEach {
                            newSecond = it.item_attach.toInt()
                            if (newSecond != oldSecond) {
                                if (index > 0) {
                                    subList.add(subTempList.toTypedArray())
                                }
                                index++
                                subTempList.clear()
                                oldSecond = newSecond
                                titleList.add(
                                        when (it.item_attach.toInt()) {
                                            in 1..28 -> YellowPagePreference.phoneBean!!.category_list[0].department_list[it.item_attach.toInt() - 1]
                                            in 29..53 -> YellowPagePreference.phoneBean!!.category_list[1].department_list[it.item_attach.toInt() - 29]
                                            in 54..75 -> YellowPagePreference.phoneBean!!.category_list[2].department_list[it.item_attach.toInt() - 54]
                                            else -> YellowPagePreference.phoneBean!!.category_list[0].department_list[0]
                                        }
                                )
                            }
                            subTempList.add(it.item_name)
                        }
                        removeRedundantElement()
                        titleList.forEachIndexed { index, s ->
                            if (index < subList.size) {
                                recyclerItems.add(SearchResultItem(this, s, subList[index].toMutableList(), query))
                            }
                            return@forEachIndexed
                        }
                        recyclerView.withItems(recyclerItems)
                    }
                }
                is RefreshState.Failure -> {
                    Toasty.error(activity(), "发生错误").show()
                }
            }
        }
    }

    fun removeRedundantElement() {
        val t = HashSet(titleList)
        val s = HashSet(subList)
        titleList.clear()
        subList.clear()
        titleList.addAll(t)
        subList.addAll(s)

    }
}
