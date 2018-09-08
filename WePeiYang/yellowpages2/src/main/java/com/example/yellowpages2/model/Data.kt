package com.example.yellowpages2.model

import com.twt.wepeiyang.commons.experimental.preference.hawk

object YellowPagePreference{

    var seachHistory : List<String> by hawk("search_histoty", listOf())

    var phoneBean : PhoneBean? by hawk("phoneBean",null)

	var collectionList : Array<SubData> by hawk("collection_list", arrayOf())

	var subArray : Array<Array<SubData>> by hawk("sub_data_list", arrayOf(arrayOf()))

}

const val ITEM_SECOND = 0
const val ITEM_COLLECTION = 1
const val ITEM_CHAR = 2

data class GroupData(
        val title:String,
        val groupIndex:Int,
        var isExpanded:Boolean = false
)

data class SubData(
		val title:String = "",
		val groupIndex: Int = 0,
		val childIndex: Int = 0,
		val type : Int = ITEM_SECOND,
		val phone: String = "0",
		val isStared: Boolean = false,
		val thirdId : Int = 0,
		val firstChar: Char = '#'
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
		val id: Int,
		val department_name: String,
		val department_attach: String,
		val unit_list: List<Unit>
)

data class Unit(
		val id: Int,
		val item_name: String,
		val item_phone: String,
		val item_attach: String
)

data class UpDateBean(
		val status: String,
		val data: List<CollectionBean>
)

data class CollectionBean(
		val id: String,
		val item_name: String,
		val item_phone: String,
		val item_attach: String
)

