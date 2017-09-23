package com.twtstudio.repair.message.model;

import com.twtstudio.repair.message.MessageBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public interface PostMessageApi {
    @POST("repairs/order/add")
    Observable<MessageBean> submitMessage ();

}
