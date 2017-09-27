package com.twtstudio.repair.detail.model;

import android.widget.Toast;

import com.twt.wepeiyang.commons.network.RetrofitProvider;
import com.twt.wepeiyang.commons.network.RxErrorHandler;
import com.twtstudio.repair.detail.DeleteBean;
import com.twtstudio.repair.detail.DetailBean;
import com.twtstudio.repair.detail.DetailContract;
import com.twtstudio.repair.main.MainBean;

import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuyuesen on 2017/9/14.
 */

public class DetailApiClient extends DetailContract.DetailModel {
    DetailContract.DetailPresenter detailPresenter;
    DetailApi detailApi;

    public DetailApiClient(DetailContract.DetailPresenter detailPresenter) {
        this.detailPresenter = detailPresenter;
    }

    @Override
    public void setData(DetailBean detailBean) {
        detailPresenter.setData(detailBean);
    }

    @Override
    public void getData(int id) {
        detailApi = RetrofitProvider.getRetrofit().create(DetailApi.class);
        detailApi.loadingData(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setData, new RxErrorHandler());
    }

    public void deleteOrder(int id){
        detailApi.deleteData(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::deleteCallBack,new RxErrorHandler());
    }

    public void deleteCallBack (DeleteBean deleteBean){
        detailPresenter.deleteCallBack(deleteBean);
    }
}
