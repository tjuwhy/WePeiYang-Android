package com.twtstudio.repair.message.model;

import com.twtstudio.repair.main.MainBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/18.
 */

public interface getMessageApi {

    @GET("repairs/order/show")
    Observable<MainBean> loadingData();
}
