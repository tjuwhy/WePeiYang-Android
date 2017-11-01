package com.twtstudio.repair.message.model;

import com.twtstudio.repair.message.BuildingListBean;
import com.twtstudio.repair.message.MessageBean;
import com.twtstudio.repair.message.RoomListBean;
import com.twtstudio.repair.message.TypeListBean;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/15.
 */

public interface MessageApi {
    @Multipart
    @POST("repairs/order/add")
    Observable<MessageBean> submitMessage(@QueryMap Map<String, Object> usermaps,
                                          @Part MultipartBody.Part part);
    //@Part("image") RequestBody requestBody);

    @POST("repairs/order/add")
    Observable<MessageBean> submitMessage(@QueryMap Map<String, Object> usermaps
                                          );

    @GET("repairs/order/area")
    Observable<BuildingListBean> getBuildingList();

    @GET("repairs/order/room")
    Observable<RoomListBean> getRoomList(@Query("area_id") int area_id);

    @GET("repairs/order/item")
    Observable<TypeListBean> getTypeList(@Query("type") int type_id);
}
