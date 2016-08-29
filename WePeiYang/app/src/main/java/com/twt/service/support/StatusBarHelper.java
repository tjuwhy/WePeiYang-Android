package com.twt.service.support;

import android.app.Activity;
import android.os.Build;


/**
 * Created by Rex on 2015/8/1.
 */
public class StatusBarHelper {

    public static void setColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().setStatusBarColor(color);
        }
    }
}
