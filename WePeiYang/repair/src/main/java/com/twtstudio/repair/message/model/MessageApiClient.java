package com.twtstudio.repair.message.model;

import com.twt.wepeiyang.commons.network.RetrofitProvider;
import com.twt.wepeiyang.commons.network.RxErrorHandler;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.MessageContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public class MessageApiClient extends MessageContract.MessageModel {
    MessageContract.MessagePresenter messagePresenter;
    PostMessageApi messageApi;

    public MessageApiClient(MessageContract.MessagePresenter messagePresenter) {
        this.messagePresenter = messagePresenter;
    }

    @Override
    public void getData() {
        messageApi = RetrofitProvider.getRetrofit().create(PostMessageApi.class);
        messageApi.submitMessage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setData, new RxErrorHandler());
    }

    @Override
    public void setData(MessageBean messageBean) {
        messagePresenter.setData(messageBean);
    }

    @Override
    public void postData(MessageBean messageBean){

        messageApi = RetrofitProvider.getRetrofit().create(PostMessageApi.class);
        messageApi.submitMessage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MessageBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        RxErrorHandler rxErrorHandler = new RxErrorHandler();
                        rxErrorHandler.call(e);
                    }

                    @Override
                    public void onNext(MessageBean messageBean) {

                    }
                });
    }


}
