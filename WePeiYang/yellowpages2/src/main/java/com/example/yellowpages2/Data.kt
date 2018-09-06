package com.example.yellowpages2

import android.support.v4.app.INotificationSideChannel
import java.util.*

const val ITEM_SECOND = 0
const val ITEM_COLLECTION = 1

data class GroupData(
        val title:String,
        val groupIndex:Int,
        var isExpanded:Boolean = false
)

data class SubData(
        val title:String,
        val groupIndex: Int,
        val childIndex: Int,
        val type : Int = ITEM_SECOND,
        val phone: String = "0",
        val isStared: Boolean = false
)

data class ChildData(
        val phone:String,
        val isStared:Boolean,
        val groupIndex: Int,
        val childIndex:Int
)

data class PhoneBean(
        val category_list: List<Category>
)

data class Category(
        val category_name: String,
        val department_list: List<Department>
)

data class Department(
        val department_name: String,
        val unit_list: List<Unit>
)

data class Unit(
        val item_name: String,
        val item_phone: String
)