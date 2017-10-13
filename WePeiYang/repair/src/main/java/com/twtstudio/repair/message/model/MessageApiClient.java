package com.twtstudio.repair.message.model;

import com.twt.wepeiyang.commons.network.RetrofitProvider;
import com.twt.wepeiyang.commons.network.RxErrorHandler;
import com.twtstudio.repair.evaluation.model.EvaluationApi;
import com.twtstudio.repair.message.BuildingListBean;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.MessageContract;
import com.twtstudio.repair.message.RoomListBean;
import com.twtstudio.repair.message.TypeListBean;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public class MessageApiClient extends MessageContract.MessageModel {
    MessageContract.MessagePresenter messagePresenter;
    MessageApi messageApi;

    public MessageApiClient(MessageContract.MessagePresenter messagePresenter) {
        this.messagePresenter = messagePresenter;
    }


    public void postMessage(Map<String, Object> map) {
        messageApi = RetrofitProvider.getRetrofit().create(MessageApi.class);
        messageApi.submitMessage(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::messageCallBack, new RxErrorHandler());
    }

    public void getBuildingList() {
        messageApi = RetrofitProvider.getRetrofit().create(MessageApi.class);
        messageApi.getBuildingList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getBuildingListCallBack, new RxErrorHandler());
    }

    public void getRoomList(int area_id) {
        messageApi = RetrofitProvider.getRetrofit().create(MessageApi.class);
        messageApi.getRoomList(area_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getRoomListCallBack, new RxErrorHandler());
    }

    public void getTypeList(int type_id) {
        messageApi = RetrofitProvider.getRetrofit().create(MessageApi.class);
        messageApi.getTypeList(type_id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::getTypeListCallBack, new RxErrorHandler());
    }


    public void messageCallBack(MessageBean messageBean) {
        messagePresenter.messageCallBack(messageBean);
    }

    public void getBuildingListCallBack(BuildingListBean buildingListBean) {
        messagePresenter.getBuildingListCallBack(buildingListBean);
    }

    public void getRoomListCallBack(RoomListBean roomListBean) {
        messagePresenter.getRoomListCallBack(roomListBean);
    }

    public void getTypeListCallBack(TypeListBean typeListBean) {
        messagePresenter.getTypeListCallBack(typeListBean);
    }


}
