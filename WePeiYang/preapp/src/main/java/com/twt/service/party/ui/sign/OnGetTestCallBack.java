package com.twt.service.party.ui.sign;

import com.twt.service.party.bean.TestInfo;

/**
 * Created by tjliqy on 2016/7/29.
 */

public interface OnGetTestCallBack {
    void onGetTestInfo(TestInfo test , String type);
    void onTestError(String msg ,String type);
    void onFailure();
}
