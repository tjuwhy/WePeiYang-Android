package com.twtstudio.repair.main.model;

import com.twtstudio.repair.main.MainBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/8/31.
 */

public interface MainApi {
    @GET("api/v1/repairs/order/show")
    Call<MainBean> loadingData();
}
