package com.twt.service.settings

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.SwitchPreference
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import com.tencent.bugly.crashreport.CrashReport
import com.twt.service.R
import com.twt.service.update.UpdateManager
import com.twt.wepeiyang.commons.cache.CacheProvider
import com.twt.wepeiyang.commons.experimental.cache.CacheIndicator.REMOTE
import com.twt.wepeiyang.commons.experimental.preference.CommonPreferences
import com.twt.wepeiyang.commons.network.RxErrorHandler
import com.twtstudio.retrox.auth.api.authSelfLiveData
import com.twtstudio.retrox.bike.service.BikeServiceProvider
import com.twtstudio.retrox.tjulibrary.provider.TjuLibProvider
import es.dmoral.toasty.Toasty
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers

/**
 * Created by retrox on 2017/2/21.
 */

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        title = "偏好设置"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fragmentManager.beginTransaction()
                .replace(R.id.settings_container, SettingsFragment())
                .commit()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()
        return super.onOptionsItemSelected(item)
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        val intent = Intent(this, HomeActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//        startActivity(intent)
//    }

    class SettingsFragment : PreferenceFragment() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.prefs)
            initPrefs()
        }

        override fun onResume() {
            super.onResume()
            val isBindLib = findPreference(getString(R.string.pref_is_bind_lib))
            isBindLib.summary = if (CommonPreferences.isBindLibrary) "已绑定" else "未绑定"
        }

        private fun initPrefs() {

            /**
             * 一键退学
             */

            val exitTjuPref = findPreference(getString(R.string.pref_is_exit_tju))
            val dropOutMode = CommonPreferences.dropOut
            var dropOutSummary = "未操作"//                    prxoyIP.setText();
            /**
             * 绑定模块
             */

            //            Preference isChangeSourceEnabled = findPreference(getString(R.string.pref_is_switch_news_source));
            //            if (BuildConfig.DEBUG){
            //                isChangeSourceEnabled.setEnabled(true);
            //            }else {
            //                isChangeSourceEnabled.setEnabled(false);
            //            }

            //null做了处理的 刷新状态
            //清空缓存 --- 课程表 GPA
            //退学
            when (dropOutMode) {
                0 -> dropOutSummary = "未操作"
                1 -> dropOutSummary = "已退学"
                2 -> dropOutSummary = "已复学"
            }
            exitTjuPref.summary = "退学状态: $dropOutSummary"

            /**
             * 这个代码有些冗杂 ... 因为一些内部类的调用关系没有理清楚但是先这样子吧
             */
            exitTjuPref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
                if (CommonPreferences.dropOut == 0 || CommonPreferences.dropOut == 2) {
                    //退学
                    val items = arrayOf("我要打游戏！", "我要运动！", "我要睡觉！", "怎么样都好啦！")

                    val builder = AlertDialog.Builder(activity)
                            .setTitle("你为啥要退学呀？")
                            .setItems(items) { dialog, which ->
                                Toast.makeText(activity, "正在办理...", Toast.LENGTH_SHORT).show()

                                RealBindAndDropOutService
                                        .dropOut(which + 1)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe({ it ->
                                            if (!TextUtils.isEmpty(it.data)) {
                                                Toast.makeText(activity, it.data, Toast.LENGTH_SHORT).show()

                                                when (it.data) {
                                                    "欢迎回来上学 (〃∀〃)" -> CommonPreferences.dropOut = 2
                                                    "退学成功 d(`･∀･)b" -> CommonPreferences.dropOut = 1
                                                }

                                                when (CommonPreferences.dropOut) {
                                                    0 -> dropOutSummary = "未操作"
                                                    1 -> dropOutSummary = "已退学"
                                                    2 -> dropOutSummary = "已复学"
                                                }
                                                exitTjuPref.summary = "退学状态: $dropOutSummary"

                                                //清空缓存 --- 课程表 GPA
                                                CacheProvider.clearCache()

                                                authSelfLiveData.refresh(REMOTE)
                                            }
                                            dialog.dismiss()
                                        }, { throwable ->
                                            authSelfLiveData.refresh(REMOTE)
                                            RxErrorHandler().call(throwable)
                                            dialog.dismiss()
                                        })
                            }

                    builder.create().show()

                } else {
                    val dropInBuilder = AlertDialog.Builder(activity)
                            .setTitle("复学申请办理处")
                            .setMessage("浪子回头金不换啊...")
                            .setPositiveButton("我想好了...") { dialog, _ ->
                                Toast.makeText(activity, "正在办理...", Toast.LENGTH_SHORT).show()

                                RealBindAndDropOutService
                                        .dropOut(0)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe({ it ->
                                            if (!TextUtils.isEmpty(it.data)) {
                                                Toast.makeText(activity, it.data, Toast.LENGTH_SHORT).show()

                                                when (it.data) {
                                                    "欢迎回来上学 (〃∀〃)" -> CommonPreferences.dropOut = 2
                                                    "退学成功 d(`･∀･)b" -> CommonPreferences.dropOut = 1
                                                }

                                                when (CommonPreferences.dropOut) {
                                                    0 -> dropOutSummary = "未操作"
                                                    1 -> dropOutSummary = "已退学"
                                                    2 -> dropOutSummary = "已复学"
                                                }
                                                exitTjuPref.summary = "退学状态: $dropOutSummary"

                                                //清空缓存 --- 课程表 GPA
                                                //null做了处理的 刷新状态

                                                CacheProvider.clearCache()

                                                authSelfLiveData.refresh(REMOTE)
                                            }
                                            dialog.dismiss()
                                        }, { throwable ->
                                            authSelfLiveData.refresh(REMOTE)
                                            RxErrorHandler().call(throwable)
                                            dialog.dismiss()
                                        })
                            }
                            .setNegativeButton("我再浪会...") { dialog, _ -> dialog.dismiss() }

                    dropInBuilder.create().show()
                }

                true
            }

            /**
             * 绑定模块
             */

            val libBindPref = findPreference(getString(R.string.pref_bind_settings))
            libBindPref.onPreferenceClickListener = Preference.OnPreferenceClickListener {
                val builder = AlertDialog.Builder(activity)
                        .setMessage("是否要跳转到绑定页面")
                        .setPositiveButton("确定") { _, _ ->
                            val intent = Intent(activity, BindActivity::class.java)
                            activity.startActivity(intent)
                        }
                builder.create().show()
                true
            }


            val isBindTju = findPreference(getString(R.string.pref_is_bind_tju))
            isBindTju.summary = if (CommonPreferences.isBindTju) "已绑定" else "未绑定"
            isBindTju.setOnPreferenceClickListener {
                val builder = AlertDialog.Builder(activity)
                        .setTitle("办公网解绑")
                        .setMessage("是否要解绑办公网")
                        .setPositiveButton("解绑") { _, _ ->
                            if (CommonPreferences.isBindTju) {
                                RealBindAndDropOutService
                                        .unbindTju(CommonPreferences.twtuname)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .doAfterTerminate({ authSelfLiveData.refresh(REMOTE) })
                                        .subscribe(Action1 { Toasty.success(activity, "解绑成功！请重启微北洋", Toast.LENGTH_SHORT).show() }, RxErrorHandler())
                            } else {
                                Toasty.warning(activity, "你没绑定解绑啥？？？？？\n点击上面按钮进入绑定页面", Toast.LENGTH_SHORT).show()
                            }
                        }
                        .setNegativeButton("再绑会...") { dialog, _ -> dialog.dismiss() }
                builder.create().show()
                false
            }

            val isBindLib = findPreference(getString(R.string.pref_is_bind_lib))
            isBindLib.summary = if (CommonPreferences.isBindLibrary) "已绑定" else "未绑定"
            isBindLib.setOnPreferenceClickListener {
                val builder = AlertDialog.Builder(activity)
                        .setTitle("图书馆解绑")
                        .setMessage("是否要解绑图书馆")
                        .setPositiveButton("解绑") { dialog, _ ->
                            if (CommonPreferences.isBindLibrary) {
                                TjuLibProvider(activity).unbindLibrary({
                                    CommonPreferences.isBindLibrary = false
                                    Toasty.success(activity, "解绑成功！请重启微北洋", Toast.LENGTH_SHORT).show()
                                    isBindLib.summary = if (CommonPreferences.isBindLibrary) "已绑定" else "未绑定"
                                    dialog.dismiss()
                                })
                            } else {
                                Toast.makeText(activity, "你没绑定解绑啥？？？？？\n点击上面按钮进入绑定页面", Toast.LENGTH_SHORT).show()
                            }
                        }
                        .setNegativeButton("再绑会...") { dialog, _ -> dialog.dismiss() }
                builder.create().show()
                false
            }

            val isBindBike = findPreference(getString(R.string.pref_is_bind_bike))
            isBindBike.summary = if (CommonPreferences.isBindBike) "已绑定" else "未绑定"
            isBindBike.setOnPreferenceClickListener {
                val builder = AlertDialog.Builder(activity)
                        .setTitle("自行车解绑")
                        .setMessage("是否要解绑自行车")
                        .setPositiveButton("解绑") { _, _ ->
                            if (CommonPreferences.isBindBike) {
                                BikeServiceProvider(activity).unbind()
                            } else {
                                Toasty.warning(activity, "你没绑定解绑啥？？？？？\n进入自行车模块完成绑定", Toast.LENGTH_SHORT).show()
                            }
                        }
                        .setNegativeButton("再绑会...") { dialog, _ -> dialog.dismiss() }
                builder.create().show()
                false
            }

            val isDisplayBike = findPreference(getString(R.string.pref_is_display_bike))
            isDisplayBike.onPreferenceChangeListener = Preference.OnPreferenceChangeListener { _, newValue ->
                if (newValue == true) Toast.makeText(activity, "打开自行车模块以完成自行车功能的激活", Toast.LENGTH_SHORT).show()
                true
            }

            //            Preference isChangeSourceEnabled = findPreference(getString(R.string.pref_is_switch_news_source));
            //            if (BuildConfig.DEBUG){
            //                isChangeSourceEnabled.setEnabled(true);
            //            }else {
            //                isChangeSourceEnabled.setEnabled(false);
            //            }

            val devTalking = findPreference(getString(R.string.pref_dev_talking))
            devTalking.setOnPreferenceClickListener {
                val intent = Intent(activity, DevTalkActivity::class.java)
                activity.startActivity(intent)
                false
            }

            val feedback = findPreference(getString(R.string.pref_feedback))
            feedback.onPreferenceClickListener = Preference.OnPreferenceClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://support.twtstudio.com/category/6/%E7%A7%BB%E5%8A%A8%E5%AE%A2%E6%88%B7%E7%AB%AF")
                activity.startActivity(intent)
                false
            }

            val contact = findPreference(getString(R.string.pref_contact_me))
            contact.onPreferenceClickListener = Preference.OnPreferenceClickListener {
                try {
                    val email = "mobile@twtstudio.com"
                    val uri = Uri.parse("mailto:$email")
                    val emailIntent = Intent(Intent.ACTION_SENDTO, uri)
                    activity.startActivity(emailIntent)
                } catch (e: Exception) {
                    Toasty.error(activity, "无法启动邮件发送APP", Toast.LENGTH_SHORT).show()
                    CrashReport.postCatchedException(e)
                    e.printStackTrace()
                }

                false
            }

            val checkUpdate = findPreference(getString(R.string.pref_check_update))
            checkUpdate.setOnPreferenceClickListener {
                UpdateManager.getInstance().checkUpdate(activity)
                true
            }

            val isAutoCheckUpdate = findPreference(getString(R.string.pref_is_auto_check_update)) as SwitchPreference
            isAutoCheckUpdate.isChecked = UpdateManager.getInstance().isAutoCheck
            isAutoCheckUpdate.setOnPreferenceChangeListener { _, newValue ->
                UpdateManager.getInstance().isAutoCheck = newValue as Boolean
                true
            }

            val proxySetting = findPreference(getString(R.string.pref_proxy_settings))
            proxySetting.setOnPreferenceClickListener {
                val inflater = LayoutInflater.from(activity)
                val dialogView = inflater.inflate(R.layout.dialog_proxy_setting, null, false)
                val proxyIP = dialogView.findViewById<EditText>(R.id.edit_proxy_ip)
                proxyIP.setText(CommonPreferences.proxyAddress)
                //                    prxoyIP.setText();
                val proxyPort = dialogView.findViewById<EditText>(R.id.edit_proxy_port)
                proxyPort.setText((CommonPreferences.proxyPort).toString())

                val dialog = AlertDialog.Builder(activity).setTitle("Proxy Settings")
                        .setView(dialogView)
                        .setPositiveButton("OK") { dialog, _ ->
                            CommonPreferences.proxyAddress = proxyIP.text.toString()
                            CommonPreferences.proxyPort = proxyPort.text.toString().toInt()
                            dialog.dismiss()
                        }
                        .setNegativeButton("Cancel", object : DialogInterface.OnClickListener {
                            override fun onClick(dialog: DialogInterface, which: Int) {
                                dialog.dismiss()
                            }
                        })
                        .create()
                dialog.show()
                true
            }


        }

        private fun processExitTju() {
            // TODO: 23/03/2017 退学逻辑
        }
    }


}
