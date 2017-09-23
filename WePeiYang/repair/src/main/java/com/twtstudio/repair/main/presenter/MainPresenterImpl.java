package com.twtstudio.repair.main.presenter;

import com.twtstudio.repair.main.MainBean;
import com.twtstudio.repair.main.MainContract;
import com.twtstudio.repair.main.model.MainApiClient;

/**
 * Created by liuyuesen on 2017/8/31.
 */

public class MainPresenterImpl extends MainContract.MainPresenter {
    MainApiClient apiClient;
    MainContract.MainView mainView;

    public MainPresenterImpl(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    public void getData() {
        apiClient = new MainApiClient(this);
        apiClient.getData();
    }

    @Override
    public void setData(MainBean mainBean) {
        mainView.setData(mainBean);
    }


}
