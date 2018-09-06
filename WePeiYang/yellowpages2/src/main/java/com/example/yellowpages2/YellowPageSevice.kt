package com.example.yellowpages2

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.twt.wepeiyang.commons.experimental.cache.*
import com.twt.wepeiyang.commons.experimental.network.ServiceFactory
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import java.util.*

interface YellowPageSevice{

    @GET("v1/yellowpage/data3")
    fun getPhone() : Deferred<PhoneBean>

    companion object : YellowPageSevice by ServiceFactory()
}

val yellowPageLocalDataCache = Cache.hawk<PhoneBean>("cache_phone_bean")
val yellowPageRemoteCache = Cache.from(YellowPageSevice.Companion::getPhone)
val yellowPageLiveData = RefreshableLiveData.use(yellowPageLocalDataCache, yellowPageRemoteCache)


