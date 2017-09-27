package com.twtstudio.repair.detail.model;

import com.twtstudio.repair.detail.DeleteBean;
import com.twtstudio.repair.detail.DetailBean;
import com.twtstudio.repair.main.MainBean;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/14.
 */

public interface DetailApi {
    @GET("/api/v1/repairs/order/detail")
    Observable<DetailBean> loadingData (@Query("order_id") String id);

    @POST("repairs/order/delete")
    Observable<DeleteBean> deleteData (@Query("order_id") int id);
}
