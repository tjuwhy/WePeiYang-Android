package com.example.yellowpages2

import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView

interface Expandable{

    fun collapse(index:Int)

    fun expand(index: Int)
}

//fun MutableList<Item>.groupItem(groupData: GroupData) = add(GroupItem(groupData.title,groupData.groupIndex))

class ExpandableHelper(recyclerView : RecyclerView, var groupData: Array<GroupData>, private val childArray:Array<Array<ChildData>> ):Expandable{

    var itemManager: ItemManager = ItemManager()
    val items = mutableListOf<Item>(HeaderItem())
    init{
        recyclerView.adapter = ItemAdapter(itemManager)
        groupData.map { it -> GroupItem(it,this) }
        items.addAll(groupData.map { it -> GroupItem(it,this)})
        itemManager.addAll(items)
    }

//    @RequiresApi(Build.VERSION_CODES.N)
    override fun collapse(index: Int) {
        var targetIndex = index + 1
        for (i in 0 until index){
            targetIndex += if (groupData[i].isExpanded) childArray[i].size else 0
        }
        for (i in targetIndex+1 .. targetIndex + childArray[index].size){
            itemManager.removeAt(i)
        }
        groupData[index].isExpanded = false
    }

    override fun expand(index: Int) {
        var targetIndex = index
        for (i in 0 until index){
            targetIndex += if (groupData[i].isExpanded) childArray[i].size else 0
        }
        itemManager.addAll(targetIndex+2/*Header*/,childArray[index].map { it -> ChildItem(it.phone,it.isStared,it.groupIndex,it.childIndex) })
        groupData[index].isExpanded = true
    }

}

