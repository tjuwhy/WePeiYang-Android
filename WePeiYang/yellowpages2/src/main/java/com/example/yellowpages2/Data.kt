package com.example.yellowpages2

import android.support.v4.app.INotificationSideChannel
import java.util.*

data class DataListTree<K,V>(val mGroupItem:K, val subItems: Array<V>)

data class GroupData(val title:String, val groupIndex:Int, var isExpanded:Boolean = false)

data class ChildData(val phone:String, val isStared:Boolean, val groupIndex: Int, val childIndex:Int)

