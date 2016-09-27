package com.twt.service;

import android.app.Application;
import android.content.Context;

import com.antfortune.freeline.FreelineCore;
import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;

import org.litepal.LitePalApplication;

import im.fir.sdk.FIR;

/**
 * Created by sunjuntao on 15/11/15.
 */
public class WePeiYangApp extends Application{

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        GrowingIO.startWithConfiguration(this, new Configuration()
                .useID()
                .trackAllFragments()
                .setChannel("Yong-Test"));

        sContext = getApplicationContext();
        LitePalApplication.initialize(this);
        FIR.init(this);
        FIR.addCustomizeValue("sdk", android.os.Build.VERSION.SDK_INT + "");
        FIR.addCustomizeValue("cpu", android.os.Build.CPU_ABI);
        FIR.addCustomizeValue("rom_provider", android.os.Build.MANUFACTURER);
        //启动推送服务
//        PushService.actionStart(this);
    }

    public static Context getContext() {
        return sContext;
    }

}
