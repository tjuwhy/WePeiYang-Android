package com.example.yellowpages2

interface YellowPageSevice{
//
//    @GET
//    fun g
}


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