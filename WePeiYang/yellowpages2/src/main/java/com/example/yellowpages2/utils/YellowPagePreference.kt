package com.example.yellowpages2.utils

import com.example.yellowpages2.model.PhoneBean
import com.example.yellowpages2.model.SubData
import com.twt.wepeiyang.commons.experimental.preference.hawk

object YellowPagePreference {

    var historyList: MutableList<String> by hawk("history_list", mutableListOf())

    var phoneBean: PhoneBean? by hawk("phoneBean", null)

    var collectionList: Array<SubData> by hawk("collection_list", arrayOf())

    var subArray: Array<Array<SubData>> by hawk("sub_data_list", arrayOf(arrayOf()))

}