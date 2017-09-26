package com.twtstudio.repair.evaluation.model;

import com.twtstudio.repair.evaluation.EvaluationBean;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/18.
 */

public interface EvaluationApi {
    @FormUrlEncoded
    @POST("repairs/grade/add")
    Observable<EvaluationBean> addEvaluation (@FieldMap Map<String ,Object> evaluationMap );
}
