package com.twtstudio.repair.complaint.model;

import com.twtstudio.repair.complaint.ComplaintBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/22.
 */

public interface ComplaintApi {
    @FormUrlEncoded
    @POST("repairs/complain/add")
    Observable<ComplaintBean> setComplaintData (@Field("order_id" )String orderId,@Field("reason") String reason,@Field("detail")String detail);
}
