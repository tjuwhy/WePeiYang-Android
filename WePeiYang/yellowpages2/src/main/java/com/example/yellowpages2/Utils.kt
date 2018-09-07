package com.example.yellowpages2

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import java.text.Collator

interface UpdateCallBack{

    fun updateView()
}

interface Expandable{

    fun collapse(index:Int)

    fun expand(index: Int)
}

//fun MutableList<Item>.groupItem(groupData: GroupData) = add(GroupItem(groupData.title,groupData.groupIndex))

class ExpandableHelper(val context :Context,recyclerView : RecyclerView, var groupData: Array<GroupData>, private val childArray:Array<Array<SubData>> ):Expandable{

    var itemManager: ItemManager = ItemManager()
    val items = mutableListOf<Item>(HeaderItem(context))
    init{
        recyclerView.adapter = ItemAdapter(itemManager)
        groupData.map { it -> GroupItem(it,this) }
        items.addAll(groupData.map { it ->
            GroupItem(it,this)
        })
        itemManager.addAll(items)
        groupData.forEachIndexed { index, groupData ->
            if (groupData.isExpanded){
                expand(index)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun collapse(index: Int) {
        var targetStart = 2 + index
        for (i in 0 until index){
            targetStart += if (groupData[i].isExpanded) childArray[i].size else 0
        }
        for (i in 0 until childArray[index].size){
            itemManager.removeAt(targetStart)
        }
    }

    override fun expand(index: Int) {
        var targetIndex = index
        for (i in 0 until index){
            targetIndex += if (groupData[i].isExpanded) childArray[i].size else 0
        }
        itemManager.addAll(targetIndex+2/*Header*/,childArray[index].
                map { it -> if (it.type == ITEM_SECOND) SubItem(context,it.title,it.groupIndex,it.childIndex,index) else
                    ChildItem(context,it.title, it.phone,it.isStared, it.thirdId)})
    }

}

class Selector(val content:String):Comparable<Selector>{

    val comparator = Collator.getInstance(java.util.Locale.CHINA)!!

    override fun compareTo(other: Selector): Int {
        return comparator.compare(content, other.content)
    }


}