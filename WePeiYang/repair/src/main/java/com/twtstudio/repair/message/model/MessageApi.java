package com.twtstudio.repair.message.model;

import com.twtstudio.repair.message.BuildingListBean;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.RoomListBean;
import com.twtstudio.repair.message.TypeListBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public interface MessageApi {
    @FormUrlEncoded
    @POST("repairs/order/add")
    Observable<MessageBean> submitMessage (@FieldMap Map<String ,Object> evaluationMap);

    @GET ("repairs/area")
    Observable <BuildingListBean> getBuildingList ();

    @GET ("repairs/room")
    Observable<RoomListBean> getRoomList (@Query("area_id") int area_id);

    @GET ("")
    Observable<TypeListBean> getTypeList (@Query("Type_id") int type_id);

}
