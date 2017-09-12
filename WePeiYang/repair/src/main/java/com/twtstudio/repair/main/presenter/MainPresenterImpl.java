package com.twtstudio.repair.main.presenter;

import android.content.Context;

import com.twtstudio.repair.base.BaseContract;
import com.twtstudio.repair.main.MainContract;
import com.twtstudio.repair.main.model.ApiClient;
import com.twtstudio.repair.main.view.MainActivity;

import static com.twtstudio.repair.main.MainContract.*;

/**
 * Created by liuyuesen on 2017/8/31.
 */

public class MainPresenterImpl extends MainContract.MainPresenter {
    ApiClient apiClient;
    MainContract.MainView mainView;

    public MainPresenterImpl(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    public void getData() {
        apiClient = new ApiClient(this);
    }

    public void setData() {
        mainView.setData();
    }

}
