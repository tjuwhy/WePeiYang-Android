package com.twtstudio.repair.main.model;

import com.twt.wepeiyang.commons.network.RetrofitProvider;
import com.twt.wepeiyang.commons.network.RxErrorHandler;
import com.twtstudio.repair.base.BaseBean;
import com.twtstudio.repair.main.MainBean;
import com.twtstudio.repair.main.MainContract;
import com.twtstudio.repair.main.presenter.MainPresenterImpl;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuyuesen on 2017/9/4.
 */

public class MainApiClient extends MainContract.MainModel {
    MainApi mainApi;
    MainContract.MainPresenter mainPresenter;


    public MainApiClient(MainContract.MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }


    public void getData() {
        mainApi = RetrofitProvider.getRetrofit().create(MainApi.class);
        mainApi.loadingData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setData, new RxErrorHandler());
    }


    public void setData(MainBean mainBean) {
        mainPresenter.setData(mainBean);
    }
}
