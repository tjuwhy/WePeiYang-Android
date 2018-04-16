package com.twt.service.schedule2.model.total

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.twt.service.schedule2.model.AbsClasstableProvider
import com.twt.service.schedule2.model.CommonClassTable
import com.twt.service.schedule2.model.MergedClassTableProvider
import com.twt.service.schedule2.model.audit.AuditCourseManager
import com.twt.service.schedule2.model.custom.CustomCourseManager
import com.twt.service.schedule2.model.school.TjuCourseApi
import com.twt.service.schedule2.model.school.refresh
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async

object TotalCourseManager {

    /**
     * 做一个内存缓存
     */
    @Volatile
    @Deprecated("use LiveDate instead")
    private var cacheMergedClassTableProvider: MergedClassTableProvider? = null // 后来用LiveData做缓存了 这个先放着...

    private val mergedClassTableProvider: MutableLiveData<MergedClassTableProvider> = MutableLiveData()

    /**
     * 如果什么都不刷新的话 并且有缓存 那就直接返回内存缓存
     * @param refreshCustom 刷新自定义课程，建议在添加自定义课程之后 做一次刷新
     */
    fun getTotalCourseManager(refreshTju: Boolean = false, refreshAudit: Boolean = false, refreshCustom: Boolean = false): LiveData<MergedClassTableProvider> {

        if (!refreshTju && !refreshAudit && !refreshCustom && (mergedClassTableProvider.value != null)) {
            val valueToRefresh = mergedClassTableProvider.value
            mergedClassTableProvider.value = valueToRefresh
            return mergedClassTableProvider
        }
        async(UI) {

            val tjuClassTableProvider: Deferred<AbsClasstableProvider> = async(CommonPool) {
                val classTable = TjuCourseApi.refresh(refreshTju)
                CommonClassTable(classTable)
            }

            val auditClasstableProvider: Deferred<AbsClasstableProvider> = async(CommonPool) {
                if (refreshAudit) {
                    AuditCourseManager.refreshAuditClasstable()
                }
                AuditCourseManager.getAuditClasstableProvider()
            }

            val customCourseProvider: Deferred<AbsClasstableProvider> = async(CommonPool) {
                CustomCourseManager.getCustomClasstableProvider()
            }

            val finalClasstableProvider = MergedClassTableProvider(
                    tjuClassTableProvider.await(),
                    auditClasstableProvider.await(),
                    customCourseProvider.await()
            )

            mergedClassTableProvider.value = finalClasstableProvider
        }.invokeOnCompletion {
            it?.apply { printStackTrace() }
        }

        return mergedClassTableProvider
    }
}