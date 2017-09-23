package com.twtstudio.repair.evaluation.model;

import com.twtstudio.repair.evaluation.EvaluationBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by liuyuesen on 2017/9/18.
 */

public interface EvaluationApi {
    @GET("repairs/grade/add")
    Observable<EvaluationBean> addEvaluation ();
}
