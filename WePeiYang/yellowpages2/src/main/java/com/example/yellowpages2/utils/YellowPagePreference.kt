package com.example.yellowpages2

import com.twt.wepeiyang.commons.experimental.preference.hawk

object YellowPagesPreference {

    var historyList: MutableList<String> by hawk("history_list", mutableListOf())

}