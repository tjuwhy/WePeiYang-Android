package com.twtstudio.repair.evaluation.model;

import com.twt.wepeiyang.commons.network.RetrofitProvider;
import com.twt.wepeiyang.commons.network.RxErrorHandler;
import com.twtstudio.repair.evaluation.EvaluationBean;
import com.twtstudio.repair.evaluation.EvaluationContract;

import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by liuyuesen on 2017/9/18.
 */

public class EvaluationApiClient extends EvaluationContract.EvaluationModel {
    EvaluationContract.EvaluationPresenter evaluationPresenter;
    EvaluationApi evaluationApi;

    public EvaluationApiClient(EvaluationContract.EvaluationPresenter evaluationPresenter) {
        this.evaluationPresenter = evaluationPresenter;
    }

    @Override
    public void postData(final Map<String, Object> evaluationMap) {
        evaluationApi = RetrofitProvider.getRetrofit().create(EvaluationApi.class);
        evaluationApi.addEvaluation(evaluationMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::EvaluationCallBack, new RxErrorHandler());
    }

    @Override
    public void EvaluationCallBack(EvaluationBean evaluationBean) {
        evaluationPresenter.EvaluationCallBack(evaluationBean);
    }
}
